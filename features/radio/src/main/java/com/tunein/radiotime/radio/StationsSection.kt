package com.tunein.radiotime.radio

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StationsSection(stations: List<Station>) {
    Column(modifier = Modifier.padding(horizontal = 15.dp)) {
        StationsSectionTop(stations.size)
        StationList(stations = stations)
    }
}

@Preview
@Composable
fun StationSectionPreview() {
    StationsSection(stations = prepareStationList())
}