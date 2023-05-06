package com.tunein.radiotime.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

import com.tunein.radiotime.common.component.ContentWithProgress
import com.tunein.radiotime.navigation.Navigator
import com.tunein.radiotime.navigation.NavigatorEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(state: MainContract.MainState, navigator: Navigator) {

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

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController, bottomBarTabs)
        }
    ) { paddingValues ->
        when (state) {
            MainContract.MainState.Loading -> {
                ContentWithProgress()
            }

            is MainContract.MainState.Success -> {
                NavGraph(
                    modifier = Modifier.padding(
                        bottom = paddingValues.calculateBottomPadding()
                    ),
                    navController = navController,
                    data = state.initialData
                )
            }
        }
    }
}