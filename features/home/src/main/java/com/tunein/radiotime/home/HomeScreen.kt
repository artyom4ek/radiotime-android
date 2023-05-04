package com.tunein.radiotime.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.tunein.radiotime.domain.model.HomeTab
import com.tunein.radiotime.home.discover.DiscoverSection

@Composable
fun HomeScreen(homeTab: HomeTab?) {
    Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp)) {
        DiscoverSection(categories = homeTab?.discover, onClick = {})
        Spacer(modifier = Modifier.size(20.dp))
        FilterSection(items = homeTab?.filter, onClick = {})
    }
}