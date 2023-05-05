package com.tunein.radiotime.radio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.domain.model.RadioTab

@Composable
fun RadioScreen(radioTab: RadioTab?) {
    Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)) {
        StationsSection(stations = radioTab?.radioStations?.toList(), onPlayClick = {})
    }
}