package com.tunein.radiotime.podcasts.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.podcasts.model.CategoryItem
import com.tunein.radiotime.podcasts.provideMusicCategories

@Composable
fun PodcastsGrid(items: List<CategoryItem>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items) { title ->
            PodcastGridItem(title, onClick = {})
        }
    }
}

@Preview
@Composable
fun PodcastsGridPreview() {
    PodcastsGrid(items = provideMusicCategories())
}