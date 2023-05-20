package com.tunein.radiotime.radio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.AsyncImage
import coil.request.ImageRequest

import com.tunein.radiotime.common.R
import com.tunein.radiotime.domain.model.AudioItem

@Composable
fun StationItem(
    station: AudioItem,
    currentStation: String?,
    isPlaying: Boolean,
    onPlayClick: (AudioItem) -> Unit
) {
    val isSelected = currentStation != null && currentStation == station.url && !isPlaying
    val playPauseIcon = if (isSelected) R.drawable.ic_pause_circle else R.drawable.ic_play_circle
    val iconTintColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data(station.cover)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.audio_placeholder),
            contentDescription = station.title,
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = station.title,
                fontSize = 16.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            station.subTitle?.let {
                Spacer(Modifier.size(5.dp))
                Text(
                    text = it,
                    color = Color.DarkGray,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        Icon(
            modifier = Modifier
                .size(32.dp)
                .clickable {
                    onPlayClick(station)
                },
            painter = painterResource(id = playPauseIcon),
            contentDescription = stringResource(id = R.string.play),
            tint = iconTintColor
        )
    }
}