package com.tunein.radiotime.navigation

import androidx.navigation.NamedNavArgument

fun interface NavigationDestination {

    fun route(route: String): String

    val arguments: List<NamedNavArgument>
        get() = emptyList()
}