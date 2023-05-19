package com.tunein.radiotime.ui.main

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

import com.tunein.radiotime.common.extentions.encodeUrl
import com.tunein.radiotime.content.DetailsScreen
import com.tunein.radiotime.content.DetailsViewModel
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.HomeTab
import com.tunein.radiotime.domain.model.PodcastsTab
import com.tunein.radiotime.domain.model.RadioTab
import com.tunein.radiotime.home.HomeScreen
import com.tunein.radiotime.home.HomeViewModel
import com.tunein.radiotime.navigation.destinations.DetailsDestination
import com.tunein.radiotime.podcasts.PodcastsScreen
import com.tunein.radiotime.podcasts.PodcastsViewModel
import com.tunein.radiotime.radio.RadioScreen

object Graph {
    const val HOME = "home_graph"
    const val RADIO = "radio_graph"
    const val PODCASTS = "podcasts_graph"
}

fun NavGraphBuilder.homeNavGraph(homeTab: HomeTab) {
    navigation(
        route = Graph.HOME,
        startDestination = BottomBarTab.Home.route
    ) {
        composable(BottomBarTab.Home.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(
                homeTab = homeTab,
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

fun NavGraphBuilder.radioNavGraph(radioTab: RadioTab, onPlayClick: (AudioItem) -> Unit) {
    navigation(
        route = Graph.RADIO,
        startDestination = BottomBarTab.Radio.route
    ) {
        composable(BottomBarTab.Radio.route) {
            RadioScreen(radioTab, onPlayClick = onPlayClick)
        }
    }
}

fun NavGraphBuilder.podcastsNavGraph(podcastsTab: PodcastsTab) {
    navigation(
        route = Graph.PODCASTS,
        startDestination = BottomBarTab.Podcasts.route
    ) {
        composable(BottomBarTab.Podcasts.route) {
            val viewModel: PodcastsViewModel = hiltViewModel()
            PodcastsScreen(podcastsTab, onClick = {
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