package com.tunein.radiotime.navigation.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

import com.tunein.radiotime.navigation.NavigationDestination

object DetailsDestination : NavigationDestination {

    const val DETAILS_URL_PARAM = "details_url"

    override fun route(route: String): String = "$route/{$DETAILS_URL_PARAM}"

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(DETAILS_URL_PARAM) { type = NavType.StringType }
        )

    fun createDetailsRoute(route: String, url: String) = "$route/$url"
}