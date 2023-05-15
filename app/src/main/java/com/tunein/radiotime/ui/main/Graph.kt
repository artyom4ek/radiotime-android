package com.tunein.radiotime.ui.main

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import com.tunein.radiotime.common.extentions.encodeUrl
import com.tunein.radiotime.content.DetailsScreen
import com.tunein.radiotime.content.DetailsViewModel
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.home.HomeScreen
import com.tunein.radiotime.home.HomeViewModel
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
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                homeTab = data?.homeTab,
                onClick = {
                    viewModel.navigate(
                        DetailsDestination.createDetailsRoute(Graph.HOME, it.encodeUrl())
                    )
                }
            )
        }
        composable(DetailsDestination.route(Graph.HOME)) {
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
                            DetailsDestination.createDetailsRoute(Graph.HOME, url.encodeUrl())
                        )
                    }
                }
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
                viewModel.navigate(
                    DetailsDestination.createDetailsRoute(
                        Graph.PODCASTS,
                        it.encodeUrl()
                    )
                )
            })
        }
        composable(DetailsDestination.route(Graph.PODCASTS)) {
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
                            DetailsDestination.createDetailsRoute(Graph.PODCASTS, url.encodeUrl())
                        )
                    }
                }
            )
        }
    }
}