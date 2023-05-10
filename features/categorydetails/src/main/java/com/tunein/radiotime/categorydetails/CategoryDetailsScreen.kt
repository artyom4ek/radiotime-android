package com.tunein.radiotime.categorydetails

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

@Composable
fun CategoryDetailsScreen(
    state: CategoryDetailsContract.CategoryDetailsState,
    onBackPress: () -> Unit,
    onClickItem: (String) -> Unit
) {
    Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp)) {
        Toolbar(title = stringResource(id = R.string.category_details)) {
            onBackPress()
        }
        when (state) {
            CategoryDetailsContract.CategoryDetailsState.Loading -> {
                ContentWithProgress()
            }

            CategoryDetailsContract.CategoryDetailsState.Empty -> {
                EmptyScreen()
            }
            is CategoryDetailsContract.CategoryDetailsState.Success -> {
                val categories = state.categories
                Spacer(modifier = Modifier.height(20.dp))
                CategoryDetailsSection(
                    categories = categories,
                    onClick = onClickItem
                )
            }
        }
    }
}