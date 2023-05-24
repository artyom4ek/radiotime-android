package com.tunein.radiotime.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.common.R
import com.tunein.radiotime.domain.model.AudioItem

/**
 * [PlayerBar] class responsible for displaying and managing the media player's playback panel.
 */
@Composable
fun PlayerBar(
    audioItem: AudioItem?,
    isPlaying: Boolean,
    onPlayClick: (AudioItem) -> Unit,
    onCloseClick: () -> Unit
) {
    val playPauseIcon = if (isPlaying) R.drawable.ic_play_arrow else R.drawable.ic_pause

    Card(shape = RoundedCornerShape(0)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = playPauseIcon),
                    contentDescription = stringResource(id = R.string.play),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            if (audioItem != null) onPlayClick(audioItem)
                        }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = audioItem?.title ?: "",
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = audioItem?.track ?: "",
                        color = Color.Gray,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(onClick = onCloseClick),
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = stringResource(id = R.string.close),
                )
            }
        }
    }
}

@Preview
@Composable
fun PlayerBarPreview() {
    PlayerBar(
        audioItem = AudioItem(
            "Radio Ukraine",
            track = "Metallica - Nothing Else Matters",
            url = ""
        ),
        isPlaying = true,
        onPlayClick = {},
        onCloseClick = {},
    )
}