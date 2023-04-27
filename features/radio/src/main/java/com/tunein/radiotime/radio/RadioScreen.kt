package com.tunein.radiotime.radio

import androidx.compose.runtime.Composable

@Composable
fun RadioScreen() {
    StationsSection(stations = prepareStationList())
}