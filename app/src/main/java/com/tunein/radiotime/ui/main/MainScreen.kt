package com.tunein.radiotime.ui.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

import com.tunein.radiotime.common.component.ContentWithProgress
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.navigation.Navigator
import com.tunein.radiotime.navigation.NavigatorEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navigator: Navigator,
    state: MainContract.State,
    onPlayClick: (AudioItem) -> Unit,
    onClosePlayerBar: () -> Unit,
    onReleasePlayer: () -> Unit
) {

    val navController = rememberNavController()
    val bottomBarTabs = listOf(
        BottomBarTab.Home,
        BottomBarTab.Radio,
        BottomBarTab.Podcasts,
    )

    LaunchedEffect(navController) {
        navigator.destinations.collect {
            when (val event = it) {
                is NavigatorEvent.NavigateUp -> {
                    navController.navigateUp()
                }

                is NavigatorEvent.Directions -> navController.navigate(
                    event.destination,
                    event.builder
                )

                NavigatorEvent.PopBackStack -> {
                    navController.popBackStack()
                }
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            onReleasePlayer()
        }
    }

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController, bottomBarTabs)
        }
    ) { paddingValues ->
        Box(Modifier.fillMaxSize()) {
            when (state.mainState) {
                MainContract.MainState.Loading -> {
                    ContentWithProgress()
                }

                is MainContract.MainState.Success -> {
                    NavGraph(
                        modifier = Modifier.padding(
                            bottom = paddingValues.calculateBottomPadding()
                        ),
                        navController = navController,
                        data = state.mainState.initialData,
                        onPlayClick = onPlayClick,
                    )
                }
            }

            AnimatedVisibility(
                modifier = Modifier
                    .padding(bottom = paddingValues.calculateBottomPadding())
                    .align(Alignment.BottomCenter),
                visible = state.audioItem != null,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                PlayerBar(
                    audioItem = state.audioItem,
                    isPlaying = state.isPlaying,
                    onPlayClick = onPlayClick,
                    onCloseClick = onClosePlayerBar
                )
            }
        }
    }
}