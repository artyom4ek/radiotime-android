package com.tunein.radiotime.ui.main.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.ui.main.MainViewModel

/**
 * NavGraph is a composable function that represents the navigation graph of the application.
 * It defines the navigation destinations and their corresponding composable screens.
 * @param modifier The modifier for the NavHost composable.
 * @param navController The NavHostController used for navigation.
 * @param mainViewModel The MainViewModel instance used for managing the main screen state.
 * @param initialData The data is required for the initial initialization of the screens of all tabs.
 * @param onPlayClick Callback function triggered when a play button is clicked.
 * @param onShowError Callback function triggered when an error needs to be shown.
*/
@Composable
fun NavGraph(
    modifier: Modifier,
    navController: NavHostController,
    mainViewModel: MainViewModel,
    initialData: InitialData,
    onPlayClick: (AudioItem) -> Unit,
    onShowError: (String) -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Graph.HOME
    ) {
        homeNavGraph(mainViewModel, initialData.homeTab, onPlayClick, onShowError)
        radioNavGraph(mainViewModel, initialData.radioTab, onPlayClick)
        podcastsNavGraph(mainViewModel, initialData.podcastsTab, onPlayClick, onShowError)
    }
}