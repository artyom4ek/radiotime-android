package com.tunein.radiotime.categorydetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.domain.model.CategoryItem

@Composable
fun AudioList(categoryItems: List<CategoryItem>, onPlayClick: (String) -> Unit) {
    if (categoryItems.isEmpty()) {
        EmptyScreen()
        return
    }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        items(categoryItems) { categoryItem ->
            AudioListItem(categoryItem = categoryItem, onPlayClick = onPlayClick)
        }
    }
}