package com.tunein.radiotime.radio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.tunein.radiotime.common.R
import com.tunein.radiotime.common.component.EmptyScreen
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.RadioTab

/**
 * [RadioScreen] displays screen with local radio station list.
 */
@Composable
fun RadioScreen(
    radioTab: RadioTab,
    currentStation: String?,
    isPlaying: Boolean,
    onPlayClick: (AudioItem) -> Unit,
) {

    if (radioTab.stations.isEmpty()) {
        EmptyScreen()
        return
    }

    Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)) {
        Column {
            Text(
                text = stringResource(id = R.string.local_stations),
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = stringResource(id = R.string.items_count, radioTab.stations.size),
                fontSize = 16.sp,
                color = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
        StationList(
            stations = radioTab.stations,
            currentStation = currentStation,
            isPlaying = isPlaying,
            onPlayClick = onPlayClick
        )
    }
}