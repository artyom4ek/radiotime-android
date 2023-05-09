package com.tunein.radiotime.navigation.destinations

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

import com.tunein.radiotime.navigation.NavigationDestination

object CategoriesDestination : NavigationDestination {

    private const val CATEGORIES_ROUTE = "categories_destination"
    const val CATEGORY_URL_PARAM = "category_url"

    override fun route(): String = "$CATEGORIES_ROUTE/{$CATEGORY_URL_PARAM}"

    override val arguments: List<NamedNavArgument>
        get() = listOf(
            navArgument(CATEGORY_URL_PARAM) { type = NavType.StringType }
        )

    fun createCategoriesRoute(categoryUrl: String) = "$CATEGORIES_ROUTE/$categoryUrl"
}