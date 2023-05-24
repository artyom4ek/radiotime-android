package com.tunein.radiotime.navigation

import androidx.navigation.NamedNavArgument

/**
 * [NavigationDestination] representing a navigation destination in the navigation graph.
 */
fun interface NavigationDestination {

    /**
     * Generates the route for the navigation destination.
     *
     * @param route The base route.
     * @return The complete route for the navigation destination.
     */
    fun route(route: String): String

    /**
     * Provides the list of named arguments for the navigation destination.
     *
     * @return The list of named arguments.
     */
    val arguments: List<NamedNavArgument>
        get() = emptyList()
}