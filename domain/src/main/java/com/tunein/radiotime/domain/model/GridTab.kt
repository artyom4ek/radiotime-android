package com.tunein.radiotime.domain.model

import androidx.annotation.DrawableRes

/**
 * [GridTab] describes sections of the Grid tab screen.
 */
data class GridTab(
    val items: List<GridItem> = emptyList(),
    val title: String,
    @DrawableRes val icon: Int? = null
) : BaseTab(baseTitle = title)
