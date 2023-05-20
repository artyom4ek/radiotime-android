package com.tunein.radiotime.radio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.domain.model.AudioItem

@Composable
fun StationList(
    stations: List<AudioItem>,
    currentStation: String?,
    isPlaying: Boolean,
    onPlayClick: (AudioItem) -> Unit
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        items(stations) { station ->
            StationItem(
                station = station,
                currentStation = currentStation,
                isPlaying = isPlaying,
                onPlayClick = onPlayClick
            )
        }
    }
}