package com.tunein.radiotime.content

import timber.log.Timber

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

import com.tunein.radiotime.common.R
import com.tunein.radiotime.common.component.LoadingScreen
import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.common.component.Toolbar
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.BaseTab
import com.tunein.radiotime.domain.model.CategoryItems

/**
 * [DetailsScreen] for displaying four category types: with tabs, audio list, lists, grids.
 */
@Suppress("UNCHECKED_CAST")
@Composable
fun DetailsScreen(
    state: DetailsContract.DetailsState,
    effect: DetailsContract.Effect?,
    currentAudioItem: String?,
    isPlaying: Boolean,
    onBackPress: () -> Unit,
    onClickItem: (String, AudioItem?) -> Unit,
    onShowError: (String) -> Unit,
) {
    Column {
        Toolbar(
            stringResource(id = R.string.category_details),
            onBackPress
        )

        when (state) {
            DetailsContract.DetailsState.Loading -> {
                LoadingScreen()
            }

            DetailsContract.DetailsState.Empty -> {
                EmptyScreen()
            }

            is DetailsContract.DetailsState.Success -> {
                val items = state.items.first
                val hasTabs = state.items.second
                if (hasTabs) {
                    ContentWithTabs(
                        tabs = items as List<BaseTab>,
                        currentAudioItem = currentAudioItem,
                        isPlaying = isPlaying,
                        onClick = onClickItem
                    )
                } else {
                    Content(
                        items = items as List<CategoryItems>,
                        currentAudioItem = currentAudioItem,
                        isPlaying = isPlaying,
                        onClick = onClickItem
                    )
                }
            }
        }
    }
    when (effect) {
        is DetailsContract.Effect.ShowError -> {
            onShowError(effect.message)
        }

        null -> {
            Timber.d("Init Details screen effect")
        }
    }
}