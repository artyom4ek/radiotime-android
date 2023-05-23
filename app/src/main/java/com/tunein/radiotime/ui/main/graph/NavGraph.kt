package com.tunein.radiotime.ui.main.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.ui.main.MainViewModel

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