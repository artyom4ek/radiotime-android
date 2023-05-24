package com.tunein.radiotime.content.audio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.content.list.CategoryListItem
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.CategoryItems
import com.tunein.radiotime.domain.model.ListItem

/**
 * [AudioList] to display the audio list.
 */
@Composable
fun AudioList(
    items: List<CategoryItems>,
    currentAudioItem: String?,
    isPlaying: Boolean,
    onPlayClick: (String, AudioItem?) -> Unit,
) {
    if (items.isEmpty()) {
        EmptyScreen()
        return
    }

    LazyColumn(
        modifier = Modifier.padding(vertical = 20.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items) { item ->
            if (item is AudioItem) {
                /*
                 * TODO: The audio item incorrectly displays the last item with the "nextStations" key.
                 * A check has been added to skip this element. Need to add a handler for this behavior.
                 */
                if (
                    !item.subTitle.isNullOrEmpty()
                    && !item.cover.isNullOrEmpty()
                    && !item.track.isNullOrEmpty()
                ) {
                    AudioListItem(
                        audioItem = item,
                        currentAudioItem = currentAudioItem,
                        isPlaying = isPlaying,
                        onPlayClick = onPlayClick
                    )
                }
            } else if (item is ListItem) {
                CategoryListItem(categoryItem = item, onClick = onPlayClick)
            }
        }
    }
}