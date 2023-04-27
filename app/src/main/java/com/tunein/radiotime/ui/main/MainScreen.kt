package com.tunein.radiotime.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.tunein.common.theme.RadiotimeTheme
import com.tunein.radiotime.podcasts.PodcastsScreen
import com.tunein.radiotime.radio.RadioScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomBarTab.Radio,
        BottomBarTab.Podcast,
    )
    Scaffold(
        bottomBar = {
            BottomBar(navController = navController, items)
        }
    ) { paddingValues ->
        NavGraph(
            modifier = Modifier.padding(
                bottom = paddingValues.calculateBottomPadding()
            ),
            navController = navController
        )
    }
}

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BottomBarTab.Radio.route
    ) {
        composable(BottomBarTab.Radio.route) {
            RadioScreen()
        }
        composable(BottomBarTab.Podcast.route) {
            PodcastsScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    RadiotimeTheme {
        MainScreen()
    }
}