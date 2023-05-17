package com.tunein.radiotime.domain.model

import androidx.annotation.DrawableRes

/**
 * [GridTab] describes a Grid Tab model
 */
data class GridTab(
    val items: List<GridItem> = emptyList(),
    val title: String,
    val key: String? = null,
    @DrawableRes val icon: Int? = null
) : BaseTab(baseTitle = title, baseKey = key)
