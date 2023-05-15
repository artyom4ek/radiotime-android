package com.tunein.radiotime.content

import androidx.compose.runtime.Composable

import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.content.audio.AudioList
import com.tunein.radiotime.content.grid.CategoryGrid
import com.tunein.radiotime.content.list.CategoryList
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.GridItem
import com.tunein.radiotime.domain.model.ListItem
import com.tunein.radiotime.domain.model.CategoryType

@Composable
fun Content(
    items: List<CategoryType>,
    onClick: (String, Boolean) -> Unit
) {
    if (items.isNotEmpty()) {
        when (items[0]) {
            is GridItem -> {
                CategoryGrid(
                    categoryItems = items as List<GridItem>,
                    onClick = onClick
                )
            }

            is ListItem -> {
                CategoryList(
                    categoryItems = items as List<ListItem>,
                    onClick = onClick
                )
            }

            is AudioItem -> {
                AudioList(categoryItems = items as List<AudioItem>, onPlayClick = onClick)
            }

            else -> EmptyScreen()
        }
    } else {
        EmptyScreen()
    }
}