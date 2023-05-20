package com.tunein.radiotime.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.common.R
import com.tunein.radiotime.common.component.ContentWithProgress
import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.common.component.Toolbar
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.BaseTab

@Suppress("UNCHECKED_CAST")
@Composable
fun DetailsScreen(
    state: DetailsContract.DetailsState,
    currentAudioItem: String?,
    isPlaying: Boolean,
    onBackPress: () -> Unit,
    onClickItem: (String, AudioItem?) -> Unit
) {
    Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp)) {
        Toolbar(
            stringResource(id = R.string.categories),
            onBackPress
        ) // TODO: add Title from Header response

        when (state) {
            DetailsContract.DetailsState.Loading -> {
                ContentWithProgress()
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
                    Spacer(modifier = Modifier.height(20.dp))
                    Content(
                        items = items,
                        currentAudioItem = currentAudioItem,
                        isPlaying = isPlaying,
                        onClick = onClickItem
                    )
                }
            }
        }
    }
}