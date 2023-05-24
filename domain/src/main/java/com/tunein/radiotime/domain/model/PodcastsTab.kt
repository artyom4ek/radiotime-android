package com.tunein.radiotime.domain.model

/**
 * [PodcastsTab] describes sections of the Podcasts tab screen.
 */
data class PodcastsTab(
    val title: String?,
    val url: String?,
    val categories: MutableList<GridTab> = mutableListOf()
)