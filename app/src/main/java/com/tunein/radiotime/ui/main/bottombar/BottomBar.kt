package com.tunein.radiotime.ui.main.bottombar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

/**
 * [BottomBar] represents the bottom navigation bar.
 * @param isBottomBarEnabled Determines if the bottom bar is enabled or disabled.
 */
@Composable
fun BottomBar(
    navController: NavController,
    isBottomBarEnabled: Boolean
) {
    val tabs = listOf(
        BottomBarTab.Home,
        BottomBarTab.Radio,
        BottomBarTab.Podcasts,
    )

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route ?: BottomBarTab.Home
        tabs.forEach { tab ->
            NavigationBarItem(icon = {
                Icon(
                    painterResource(id = tab.icon),
                    modifier = Modifier.size(size = 26.dp),
                    contentDescription = stringResource(tab.title)
                )
            },
                label = {
                    Text(
                        text = stringResource(tab.title), fontSize = 12.sp
                    )
                },
                alwaysShowLabel = true,
                selected = currentRoute == tab.route,
                enabled = isBottomBarEnabled,
                onClick = {
                    navController.navigate(tab.route) {
                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        /*
                         * FIXME: By default, this flag should be set to True.
                         * But this causes navigation problems and crashes.
                         * Additional investigation of the problem is needed.
                         */
                        restoreState = false
                    }
                })
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar(
        navController = rememberNavController(),
        isBottomBarEnabled = true
    )
}