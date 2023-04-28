package com.tunein.radiotime.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)) {
        DiscoverSection(categories = provideDiscoverCategories(), onClick = {})
    }
}