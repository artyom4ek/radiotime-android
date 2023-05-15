package com.tunein.radiotime.ui.main

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import com.tunein.radiotime.categories.CategoriesScreen
import com.tunein.radiotime.categories.CategoriesViewModel
import com.tunein.radiotime.categorydetails.CategoryDetailsScreen
import com.tunein.radiotime.categorydetails.CategoryDetailsViewModel
import com.tunein.radiotime.common.extentions.encodeUrl
import com.tunein.radiotime.content.DetailsScreen
import com.tunein.radiotime.content.DetailsViewModel
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.home.HomeScreen
import com.tunein.radiotime.navigation.destinations.CategoriesDestination
import com.tunein.radiotime.navigation.destinations.CategoryDetailsDestination
import com.tunein.radiotime.navigation.destinations.DetailsDestination
import com.tunein.radiotime.podcasts.PodcastsScreen
import com.tunein.radiotime.podcasts.PodcastsViewModel

object Graph {
    const val HOME = "home_graph"
    const val PODCASTS = "podcasts_graph"
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
                onBackPress = { viewModel.navigateUp() },
                onClickItem = {
                    viewModel.navigate(
                        CategoryDetailsDestination.createCategoryDetailsRoute(it.encodeUrl())
                    )
                }
            )
        }
        composable(CategoryDetailsDestination.route()) {
            val viewModel: CategoryDetailsViewModel = hiltViewModel()
            val uiState = viewModel.uiState.collectAsState()
            CategoryDetailsScreen(
                uiState.value.categoryDetailsState,
                onBackPress = { viewModel.navigateUp() },
                onClickItem = { }
            )
        }
    }
}

fun NavGraphBuilder.podcastNavGraph(data: InitialData?) {
    navigation(
        route = Graph.PODCASTS,
        startDestination = BottomBarTab.Podcasts.route
    ) {
        composable(BottomBarTab.Podcasts.route) {
            val viewModel: PodcastsViewModel = hiltViewModel()
            PodcastsScreen(data?.podcastsTab, onClick = {
                viewModel.navigate(DetailsDestination.createDetailsRoute(it.encodeUrl()))
            })
        }
        composable(DetailsDestination.route()) {
            val viewModel: DetailsViewModel = hiltViewModel()
            val uiState = viewModel.uiState.collectAsState()
            DetailsScreen(
                uiState.value.detailsState,
                onBackPress = { viewModel.navigateUp() },
                onClickItem = { url, isAudio ->
                    if (isAudio) {
                        // Audio
                    } else {
                        viewModel.navigate(
                            DetailsDestination.createDetailsRoute(url.encodeUrl())
                        )
                    }
                }
            )
        }
    }
}