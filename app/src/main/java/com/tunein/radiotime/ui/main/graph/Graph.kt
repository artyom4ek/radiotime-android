package com.tunein.radiotime.ui.main.graph

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
import com.tunein.radiotime.ui.main.MainViewModel
import com.tunein.radiotime.ui.main.bottombar.BottomBarTab

/**
 * [Graph] contains name of routes for nested graphs.
 */
object Graph {
    const val HOME = "home_graph"
    const val RADIO = "radio_graph"
    const val PODCASTS = "podcasts_graph"
}

/**
 * Defines the nested navigation graph for the Home tab.
 * @param mainViewModel The MainViewModel instance used for managing the Playback state.
 * @param homeTab Contains initial data for Home Tab.
 * @param onPlayClick Callback function triggered when a play button is clicked.
 * @param onShowError Callback function triggered when an error needs to be shown.
 */
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
            // Used to use navigation.
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
            /*
             * In this context, the MainViewModel is used to get the currently playing audio item
             * when updating the data.
             */
            val mainState = mainViewModel.uiState.collectAsState()
            val currentAudioItem = mainState.value.currentAudioItem?.url
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

/**
 * Defines the nested navigation graph for the Radio tab.
 * @param mainViewModel The MainViewModel instance used for managing the Playback state.
 * @param radioTab Contains initial data for Radio Tab.
 * @param onPlayClick Callback function triggered when a play button is clicked.
 */
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
            /*
             * In this context, the MainViewModel is used to get the currently playing audio item
             * when updating the data.
             */
            val mainState = mainViewModel.uiState.collectAsState()
            val currentStation = mainState.value.currentAudioItem?.url
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

/**
 * Defines the nested navigation graph for the Podcasts tab.
 * @param mainViewModel The MainViewModel instance used for managing the Playback state.
 * @param podcastsTab Contains initial data for Podcasts Tab.
 * @param onPlayClick Callback function triggered when a play button is clicked.
 * @param onShowError Callback function triggered when an error needs to be shown.
 **/
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
            /*
             * In this context, the MainViewModel is used to get the currently playing audio item
             * when updating the data.
             */
            val mainState = mainViewModel.uiState.collectAsState()
            val currentAudioItem = mainState.value.currentAudioItem
            val isPlaying = mainState.value.isPlaying

            val detailsViewModel: DetailsViewModel = hiltViewModel()
            val uiState = detailsViewModel.uiState.collectAsState()
            val effect = detailsViewModel.effect.collectAsState(null)
            DetailsScreen(
                state = uiState.value.detailsState,
                effect = effect.value,
                currentAudioItem = currentAudioItem?.url,
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