package com.tunein.radiotime.categorydetails

import androidx.compose.runtime.Composable

import com.tunein.radiotime.domain.model.Category

@Composable
fun TabScreen(category: Category, onClick: (String) -> Unit) {
    when (category.key) {
        "local", "stations" -> {
            AudioList(categoryItems = category.items, onPlayClick = onClick)
        }

        "shows" -> {
            CategoryList(categoryItems = category.items, onClick = onClick)
        }

        "related" -> {
            CategoryGrid(categoryItems = category.items, onClick = onClick)
        }
    }
}