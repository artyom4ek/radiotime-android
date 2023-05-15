package com.tunein.radiotime.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.Flow

interface Navigator {
    fun navigateUp(): Boolean
    fun popBackStack()
    fun navigate(
        route: String,
        builder: NavOptionsBuilder.() -> Unit = { launchSingleTop = false }
    ): Boolean

    val destinations: Flow<NavigatorEvent>
}