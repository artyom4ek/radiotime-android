package com.tunein.radiotime.content.audio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.domain.model.AudioItem

@Composable
fun AudioList(
    audioItems: List<AudioItem>,
    currentAudioItem: String?,
    isPlaying: Boolean,
    onPlayClick: (String, AudioItem?) -> Unit,
) {
    if (audioItems.isEmpty()) {
        EmptyScreen()
        return
    }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        items(audioItems) { audioItem ->
            AudioListItem(
                audioItem = audioItem,
                currentAudioItem = currentAudioItem,
                isPlaying = isPlaying,
                onPlayClick = onPlayClick
            )
        }
    }
}