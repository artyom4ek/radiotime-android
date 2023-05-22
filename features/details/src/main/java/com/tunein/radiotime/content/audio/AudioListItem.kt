package com.tunein.radiotime.content.audio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.AsyncImage
import coil.request.ImageRequest

import com.tunein.radiotime.common.R
import com.tunein.radiotime.domain.model.AudioItem

@Composable
fun AudioListItem(
    audioItem: AudioItem,
    currentAudioItem: String?,
    isPlaying: Boolean,
    onPlayClick: (String, AudioItem?) -> Unit,
) {
    val isSelected = currentAudioItem != null && currentAudioItem == audioItem.url && !isPlaying
    val playPauseIcon = if (isSelected) R.drawable.ic_pause_circle else R.drawable.ic_play_circle
    val iconTintColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray

    Row(
        modifier = Modifier
            .padding(end = 5.dp)
            .heightIn(min = 56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        audioItem.cover?.let {
            AsyncImage(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(it)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.audio_placeholder),
                contentDescription = audioItem.title,
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = audioItem.title,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = audioItem.subTitle!!,
                fontSize = 13.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            audioItem.track?.let {
                Spacer(Modifier.size(2.dp))
                Text(
                    text = stringResource(
                        id = R.string.current_track, it
                    ),
                    color = Color.Gray,
                    fontStyle = FontStyle.Italic,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        Icon(
            modifier = Modifier
                .size(32.dp)
                .clickable {
                    onPlayClick(audioItem.url, audioItem)
                },
            painter = painterResource(id = playPauseIcon),
            contentDescription = stringResource(id = R.string.play),
            tint = iconTintColor
        )
    }
}