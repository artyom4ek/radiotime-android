package com.tunein.radiotime.domain.model

/**
 * [HomeTab] model describes sections of the Home screen
 */
data class HomeTab(
    val discover: List<Category>,
    val filter: List<Category>
)
