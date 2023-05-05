package com.tunein.radiotime.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

import com.tunein.radiotime.common.component.ContentWithProgress
import com.tunein.radiotime.common.theme.RadiotimeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(state: MainContract.MainState) {
    
    val navController = rememberNavController()
    val bottomBarTabs = listOf(
        BottomBarTab.Home,
        BottomBarTab.Radio,
        BottomBarTab.Podcasts,
    )

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

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    RadiotimeTheme {
        MainScreen(MainContract.MainState.Success(null))
    }
}