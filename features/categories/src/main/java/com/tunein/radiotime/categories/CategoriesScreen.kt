package com.tunein.radiotime.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.common.R
import com.tunein.radiotime.common.component.ContentWithProgress
import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.common.component.Toolbar

@Composable
fun CategoriesScreen(
    state: CategoriesContract.CategoriesState,
    onBackPress: () -> Unit
) {

    Column(modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp)) {
        Toolbar(stringResource(id = R.string.categories), onBackPress)
        Spacer(modifier = Modifier.height(20.dp))
        when (state) {
            CategoriesContract.CategoriesState.Loading -> {
                ContentWithProgress()
            }

            CategoriesContract.CategoriesState.Empty -> {
                EmptyScreen()
            }

            is CategoriesContract.CategoriesState.Success -> {
                val categories = state.categories
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(categories) { title ->
                        CategoryGridItem(title, onClick = {})
                    }
                }
            }
        }
    }
}