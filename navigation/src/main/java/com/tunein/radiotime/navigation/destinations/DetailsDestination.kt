package com.tunein.radiotime.navigation.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

import com.tunein.radiotime.navigation.NavigationDestination

object DetailsDestination : NavigationDestination {

    private const val DETAILS_ROUTE = "details_destination"
    const val DETAILS_URL_PARAM = "details_url"

    override fun route(): String = "$DETAILS_ROUTE/{$DETAILS_URL_PARAM}"

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(DETAILS_URL_PARAM) { type = NavType.StringType }
        )

    fun createDetailsRoute(url: String) = "$DETAILS_ROUTE/$url"
}