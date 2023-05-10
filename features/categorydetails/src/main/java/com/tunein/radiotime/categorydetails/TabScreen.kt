package com.tunein.radiotime.categorydetails

import androidx.compose.runtime.Composable

import com.tunein.radiotime.common.network.ResponseKeys
import com.tunein.radiotime.domain.model.Category

@Composable
fun TabScreen(category: Category, onClick: (String) -> Unit) {
    when (category.key) {
        ResponseKeys.LOCAL.key, ResponseKeys.STATIONS.key -> {
            AudioList(categoryItems = category.items, onPlayClick = onClick)
        }

        ResponseKeys.SHOWS.key -> {
            CategoryList(categoryItems = category.items, onClick = onClick)
        }

        ResponseKeys.RELATED.key -> {
            CategoryGrid(categoryItems = category.items, onClick = onClick)
        }
    }
}