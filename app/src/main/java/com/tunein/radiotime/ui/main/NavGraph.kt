package com.tunein.radiotime.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.InitialData

@Composable
fun NavGraph(
    modifier: Modifier,
    navController: NavHostController,
    data: InitialData,
    onPlayClick: (AudioItem) -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Graph.HOME
    ) {
        homeNavGraph(data.homeTab, onPlayClick)
        radioNavGraph(data.radioTab, onPlayClick)
        podcastsNavGraph(data.podcastsTab, onPlayClick)
    }
}