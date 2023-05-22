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

fun NavGraphBuilder.homeNavGraph(
    mainViewModel: MainViewModel,
    homeTab: HomeTab,
    onPlayClick: (AudioItem) -> Unit,
    onShowError: (String) -> Unit
) {
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
            val mainState = mainViewModel.uiState.collectAsState()
            val currentAudioItem = mainState.value.currentTrack
            val isPlaying = mainState.value.isPlaying

            val detailsViewModel: DetailsViewModel = hiltViewModel()
            val uiState = detailsViewModel.uiState.collectAsState()
            val effect = detailsViewModel.effect.collectAsState(null)
            DetailsScreen(
                state = uiState.value.detailsState,
                effect = effect.value,
                currentAudioItem = currentAudioItem,
                isPlaying = isPlaying,
                onBackPress = { detailsViewModel.navigateUp() },
                onClickItem = { url, audioItem ->
                    if (audioItem != null) {
                        onPlayClick(audioItem)
                    } else {
                        detailsViewModel.navigate(
                            DetailsDestination.createDetailsRoute(Graph.HOME, url.encodeUrl())
                        )
                    }
                },
                onShowError = onShowError
            )
        }
    }
}

fun NavGraphBuilder.radioNavGraph(
    mainViewModel: MainViewModel,
    radioTab: RadioTab,
    onPlayClick: (AudioItem) -> Unit
) {
    navigation(
        route = Graph.RADIO,
        startDestination = BottomBarTab.Radio.route
    ) {
        composable(BottomBarTab.Radio.route) {
            val mainState = mainViewModel.uiState.collectAsState()
            val currentStation = mainState.value.currentTrack
            val isPlaying = mainState.value.isPlaying
            RadioScreen(
                radioTab = radioTab,
                currentStation = currentStation,
                isPlaying = isPlaying,
                onPlayClick = onPlayClick
            )
        }
    }
}

fun NavGraphBuilder.podcastsNavGraph(
    mainViewModel: MainViewModel,
    podcastsTab: PodcastsTab,
    onPlayClick: (AudioItem) -> Unit,
    onShowError: (String) -> Unit
) {
    navigation(
        route = Graph.PODCASTS,
        startDestination = BottomBarTab.Podcasts.route
    ) {
        composable(BottomBarTab.Podcasts.route) {
            val podcastsViewModel: PodcastsViewModel = hiltViewModel()
            PodcastsScreen(podcastsTab, onClick = {
                podcastsViewModel.navigate(
                    DetailsDestination.createDetailsRoute(
                        Graph.PODCASTS,
                        it.encodeUrl()
                    )
                )
            })
        }
        composable(DetailsDestination.route(Graph.PODCASTS)) {
            val mainState = mainViewModel.uiState.collectAsState()
            val currentAudioItem = mainState.value.currentTrack
            val isPlaying = mainState.value.isPlaying

            val detailsViewModel: DetailsViewModel = hiltViewModel()
            val uiState = detailsViewModel.uiState.collectAsState()
            val effect = detailsViewModel.effect.collectAsState(null)
            DetailsScreen(
                state = uiState.value.detailsState,
                effect = effect.value,
                currentAudioItem = currentAudioItem,
                isPlaying = isPlaying,
                onBackPress = { detailsViewModel.navigateUp() },
                onClickItem = { url, audioItem ->
                    if (audioItem != null) {
                        onPlayClick(audioItem)
                    } else {
                        detailsViewModel.navigate(
                            DetailsDestination.createDetailsRoute(Graph.PODCASTS, url.encodeUrl())
                        )
                    }
                },
                onShowError = onShowError
            )
        }
    }
}