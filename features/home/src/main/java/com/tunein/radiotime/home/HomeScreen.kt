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
import com.tunein.radiotime.home.filters.FiltersSection

/**
 * [HomeScreen] to display Home Tab screen.
 */
@Composable
fun HomeScreen(homeTab: HomeTab?, onClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)) {
        DiscoverSection(categories = homeTab?.discover, onClick = onClick)
        Spacer(modifier = Modifier.size(20.dp))
        FiltersSection(filters = homeTab?.filter, onClick = onClick)
    }
}