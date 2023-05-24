package com.tunein.radiotime.navigation

import androidx.navigation.NavOptionsBuilder

/**
 * [NavigatorEvent] representing events related to navigation.
 */
sealed class NavigatorEvent {
    object NavigateUp : NavigatorEvent()

    /**
     * Event indicating the navigation should navigate to a specific destination with optional navigation options.
     *
     * @property destination The destination to navigate to.
     * @property builder The optional builder for navigation options.
     */
    class Directions(
        val destination: String,
        val builder: NavOptionsBuilder.() -> Unit
    ) : NavigatorEvent()

    object PopBackStack : NavigatorEvent()
}