package com.tunein.radiotime.content.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.ListItem

@Composable
fun CategoryList(categoryItems: List<ListItem>, onClick: (String, AudioItem?) -> Unit) {
    if (categoryItems.isEmpty()) {
        EmptyScreen()
        return
    }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        items(categoryItems) {
            CategoryListItem(categoryItem = it, onClick = onClick)
        }
    }
}