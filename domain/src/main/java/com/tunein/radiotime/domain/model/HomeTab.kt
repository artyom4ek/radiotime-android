package com.tunein.radiotime.domain.model

/**
 * [HomeTab] describes sections of the Home tab screen.
 */
data class HomeTab(
    val discover: List<GridItem>,
    val filter: List<GridItem>
)
