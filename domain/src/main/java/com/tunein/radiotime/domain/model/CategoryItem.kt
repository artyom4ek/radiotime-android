package com.tunein.radiotime.domain.model

import androidx.annotation.DrawableRes

/**
 * [CategoryItem] describes a category item model
 */
data class CategoryItem(
    val title: String,
    val url: String,
    val subTitle: String? = null,
    val currentTrack: String? = null,
    val cover: String? = null,
    val count: Int? = null,
    @DrawableRes val icon: Int? = null
) : CategoryType
