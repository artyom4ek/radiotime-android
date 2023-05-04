package com.tunein.radiotime.home.discover

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.domain.model.CategoryItem

@Composable
fun DiscoverGrid(categories: List<CategoryItem>, onClick: (String) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(categories) { categoryItem ->
            DiscoverGridItem(categoryItem, onClick)
        }
    }
}