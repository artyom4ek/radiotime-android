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

@Suppress("UNCHECKED_CAST")
@Composable
fun Content(
    items: List<CategoryType>,
    currentAudioItem: String?,
    isPlaying: Boolean,
    onClick: (String, AudioItem?) -> Unit,
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
                AudioList(
                    audioItems = items as List<AudioItem>,
                    onPlayClick = onClick,
                    currentAudioItem = currentAudioItem,
                    isPlaying = isPlaying
                )
            }

            else -> EmptyScreen()
        }
    } else {
        EmptyScreen()
    }
}