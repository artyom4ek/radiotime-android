package com.tunein.radiotime.domain.model

/**
 * [PodcastsTab] store data for Podcasts screen
 */
data class PodcastsTab(
    val title: String?,
    val url: String?,
    val categories: MutableList<GridTab> = mutableListOf()
)