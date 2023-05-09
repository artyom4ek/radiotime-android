package com.tunein.radiotime.ui.main

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import com.tunein.radiotime.categories.CategoriesScreen
import com.tunein.radiotime.categories.CategoriesViewModel
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.home.HomeScreen
import com.tunein.radiotime.navigation.destinations.CategoriesDestination

object Graph {
    const val HOME = "home_graph"
}

fun NavGraphBuilder.homeNavGraph(data: InitialData?) {
    navigation(
        route = Graph.HOME,
        startDestination = BottomBarTab.Home.route
    ) {
        composable(BottomBarTab.Home.route) {
            HomeScreen(data?.homeTab)
        }
        composable(CategoriesDestination.route()) {
            val viewModel: CategoriesViewModel = hiltViewModel()
            val uiState = viewModel.uiState.collectAsState()
            CategoriesScreen(
                uiState.value.categoriesState,
                onBackPress = { viewModel.navigateUp() })
        }
    }
}