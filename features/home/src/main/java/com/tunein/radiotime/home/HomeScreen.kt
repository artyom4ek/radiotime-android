package com.tunein.radiotime.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import com.tunein.radiotime.common.extentions.encodeUrl
import com.tunein.radiotime.domain.model.HomeTab
import com.tunein.radiotime.home.discover.DiscoverSection
import com.tunein.radiotime.home.filters.FiltersSection
import com.tunein.radiotime.navigation.destinations.CategoriesDestination

@Composable
fun HomeScreen(homeTab: HomeTab?) {
    val viewModel: HomeViewModel = hiltViewModel()

    Column(modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp)) {
        DiscoverSection(categories = homeTab?.discover, onClick = {
            viewModel.navigate(
                CategoriesDestination.createCategoriesRoute(it.encodeUrl())
            )
        })
        Spacer(modifier = Modifier.size(20.dp))
        FiltersSection(filters = homeTab?.filter, onClick = {
            viewModel.navigate(
                CategoriesDestination.createCategoriesRoute(it.encodeUrl())
            )
        })
    }
}