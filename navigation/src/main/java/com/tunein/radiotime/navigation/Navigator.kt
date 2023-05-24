package com.tunein.radiotime.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.flow.Flow

/**
 * [Navigator] representing a navigator that handles navigation within the application.
 */
interface Navigator {

    /**
     * Navigates up in the navigation hierarchy.
     *
     * @return `true` if the navigation was handled successfully, `false` otherwise.
     */
    fun navigateUp(): Boolean

    /**
     * Pops the back stack, navigating to the previous destination.
     */
    fun popBackStack()

    /**
     * Navigates to the specified route with optional navigation options.
     *
     * @param route The route to navigate to.
     * @param builder The optional builder for navigation options.
     * @return `true` if the navigation was handled successfully, `false` otherwise.
     */
    fun navigate(
        route: String,
        builder: NavOptionsBuilder.() -> Unit = { launchSingleTop = false }
    ): Boolean

    /**
     * Retrieves the flow of navigator events, representing the current destinations in the navigation stack.
     *
     * @return The flow of navigator events.
     */
    val destinations: Flow<NavigatorEvent>
}