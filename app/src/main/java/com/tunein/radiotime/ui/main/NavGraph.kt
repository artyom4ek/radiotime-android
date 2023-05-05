package com.tunein.radiotime.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.home.HomeScreen
import com.tunein.radiotime.podcasts.PodcastsScreen
import com.tunein.radiotime.radio.RadioScreen

@Composable
fun NavGraph(
    modifier: Modifier,
    navController: NavHostController,
    data: InitialData?
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomBarTab.Home.route
    ) {
        composable(BottomBarTab.Home.route) {
            HomeScreen(data?.homeTab)
        }
        composable(BottomBarTab.Radio.route) {
            RadioScreen(data?.radioTab)
        }
        composable(BottomBarTab.Podcasts.route) {
            PodcastsScreen()
        }
    }
}