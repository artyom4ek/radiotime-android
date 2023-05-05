package com.tunein.radiotime.domain.model

import androidx.annotation.DrawableRes

/**
 * [CategoryItem] model describes a category that is universal
 */
data class CategoryItem(
    val title: String,
    val url: String,
    @DrawableRes val icon: Int? = null
)
