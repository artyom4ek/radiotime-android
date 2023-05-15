package com.tunein.radiotime.domain.model

/**
 * [GridTab] describes a Grid Tab model
 */
data class GridTab(
    val title: String,
    val key: String?,
    val items: List<GridItem> = emptyList(),
) : BaseTab(baseTitle = title, baseKey = key)