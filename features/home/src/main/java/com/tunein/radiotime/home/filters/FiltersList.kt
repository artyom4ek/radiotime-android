package com.tunein.radiotime.home.filters

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.domain.model.GridItem

/**
 * [FiltersList] displays the list of filters.
 */
@Composable
fun FiltersList(items: List<GridItem>, onClick: (String) -> Unit) {
    LazyColumn {
        itemsIndexed(items) { index, item ->
            FiltersListItem(item, onClick)

            // Add dividers without last element.
            if (items.size > 1 && index < items.size - 1) {
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp
                )
            }
        }
    }
}