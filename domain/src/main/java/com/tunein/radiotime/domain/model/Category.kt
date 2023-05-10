package com.tunein.radiotime.domain.model

import androidx.annotation.DrawableRes

/**
 * [Category] model describes a category that is universal
 */
data class Category(
    val title: String,
    val key: String?,
    val items: List<CategoryItem> = emptyList(),
    @DrawableRes val icon: Int? = null
)
