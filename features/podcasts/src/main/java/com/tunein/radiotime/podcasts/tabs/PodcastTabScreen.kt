package com.tunein.radiotime.podcasts.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.domain.model.CategoryItem

@Composable
fun PodcastTabScreen(items: List<CategoryItem>, onClick: (String) -> Unit) {
    LazyVerticalGrid(
        modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp),
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items) { title ->
            PodcastGridItem(title, onClick = onClick)
        }
    }
}