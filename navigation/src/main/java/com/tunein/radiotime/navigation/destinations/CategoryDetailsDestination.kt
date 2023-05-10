package com.tunein.radiotime.navigation.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

import com.tunein.radiotime.navigation.NavigationDestination

object CategoryDetailsDestination : NavigationDestination {

    private const val CATEGORY_DETAILS_ROUTE = "category_details_destination"
    const val CATEGORY_DETAILS_URL_PARAM = "category_details_url"

    override fun route(): String = "$CATEGORY_DETAILS_ROUTE/{$CATEGORY_DETAILS_URL_PARAM}"

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(CATEGORY_DETAILS_URL_PARAM) { type = NavType.StringType }
        )

    fun createCategoryDetailsRoute(url: String) = "$CATEGORY_DETAILS_ROUTE/$url"
}