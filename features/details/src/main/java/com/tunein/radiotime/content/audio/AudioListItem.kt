package com.tunein.radiotime.content.audio

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
    categoryItem: AudioItem,
    onPlayClick: (String, Boolean) -> Unit
) {
    Row(
        modifier = Modifier.padding(end = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            modifier = Modifier
                .size(56.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data(categoryItem.cover)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.audio_placeholder),
            contentDescription = categoryItem.title,
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 10.dp)
        ) {
            Text(
                text = categoryItem.title,
                color = Color.DarkGray,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = categoryItem.subTitle!!,
                color = Color.DarkGray,
                fontSize = 11.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            categoryItem.track?.let {
                Spacer(Modifier.size(2.dp))
                Text(
                    text = stringResource(
                        id = R.string.current_track, it
                    ),
                    color = Color.Gray,
                    fontStyle = FontStyle.Italic,
                    fontSize = 10.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
        Icon(
            modifier = Modifier
                .size(32.dp)
                .clickable {
                    onPlayClick(categoryItem.url, true)
                },
            painter = painterResource(id = R.drawable.ic_play_circle),
            contentDescription = stringResource(id = R.string.play),
            tint = Color.Gray
        )
    }
}