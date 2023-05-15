package com.tunein.radiotime.content.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.domain.model.GridItem

@Composable
fun CategoryGrid(categoryItems: List<GridItem>, onClick: (String, Boolean) -> Unit) {
    if (categoryItems.isEmpty()) {
        EmptyScreen()
        return
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(categoryItems) { categoryItem ->
            CategoryGridItem(categoryItem, onClick = onClick)
        }
    }
}