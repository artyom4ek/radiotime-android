package com.tunein.radiotime.domain.model

import androidx.annotation.DrawableRes

/**
 * [GridItem] describes a Category Grid item model
 */
data class GridItem(
    val title: String,
    val url: String,
    @DrawableRes val icon: Int? = null
) : CategoryItems
