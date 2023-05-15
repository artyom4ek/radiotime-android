package com.tunein.radiotime.domain.model

/**
 * [ListItem] describes a List Item model
 */
data class ListItem(
    val title: String,
    val url: String,
    val subTitle: String? = null,
    val currentTrack: String? = null,
    val cover: String? = null,
) : CategoryItems
