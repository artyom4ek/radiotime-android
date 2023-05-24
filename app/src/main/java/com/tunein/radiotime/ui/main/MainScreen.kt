package com.tunein.radiotime.ui.main

import timber.log.Timber

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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

import com.tunein.radiotime.common.component.LoadingScreen
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.navigation.Navigator
import com.tunein.radiotime.navigation.NavigatorEvent
import com.tunein.radiotime.ui.main.bottombar.BottomBar
import com.tunein.radiotime.ui.main.graph.NavGraph

/**
 * [MainScreen] is a composable function that represents the main user interface of the app.
 * @param navigator The navigator used for navigating between screens.
 * @param mainViewModel The ViewModel instance used for managing the main screen state and logic.
 * @param onPlayClick Callback function triggered when the user clicks on the play button for an audio item.
 * @param onClosePlayerBar Callback function triggered when the user closes the player bar.
 * @param onReleasePlayer Callback function triggered when the player needs to be released.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navigator: Navigator,
    mainViewModel: MainViewModel,
    onPlayClick: (AudioItem) -> Unit,
    onClosePlayerBar: () -> Unit,
    onReleasePlayer: () -> Unit
) {
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val uiState = mainViewModel.uiState.collectAsState().value
    val effect = mainViewModel.effect.collectAsState(null).value

    // Disable clicking BottomBar items while initial data is loading.
    var isBottomBarEnabled by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        bottomBar = {
            BottomBar(navController, isBottomBarEnabled)
        }
    ) { paddingValues ->
        Box(Modifier.fillMaxSize()) {
            when (uiState.mainState) {
                MainContract.MainState.Loading -> {
                    LoadingScreen()
                }

                is MainContract.MainState.Success -> {
                    isBottomBarEnabled = true
                    NavGraph(
                        modifier = Modifier.padding(
                            bottom = paddingValues.calculateBottomPadding()
                        ),
                        navController = navController,
                        mainViewModel = mainViewModel,
                        initialData = uiState.mainState.initialData,
                        onPlayClick = onPlayClick,
                        onShowError = {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar(it)
                            }
                        }
                    )
                }
            }

            // Show the PlayerBar with animation when the state of the parameters changes.
            AnimatedVisibility(
                modifier = Modifier
                    .padding(bottom = paddingValues.calculateBottomPadding())
                    .align(Alignment.BottomCenter),
                visible = uiState.currentAudioItem != null,
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                PlayerBar(
                    audioItem = uiState.currentAudioItem,
                    isPlaying = uiState.isPlaying,
                    onPlayClick = onPlayClick,
                    onCloseClick = onClosePlayerBar
                )
            }
        }
    }

    // LaunchedEffect is used to perform side effects when certain dependencies or values change.
    LaunchedEffect(navController, snackbarHostState, effect) {
        // Display the effects that are described in Main Contract
        when (effect) {
            is MainContract.Effect.ShowError -> {
                snackbarHostState.showSnackbar(effect.message)
            }

            null -> {
                Timber.d("Init Main screen effect")
            }
        }

        /*
         * Global navigation interceptor.
         * Linked to the Navigation module where the main logic is described.
         */
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

    // Release the player when the composable is disposed.
    DisposableEffect(Unit) {
        onDispose {
            onReleasePlayer()
        }
    }
}