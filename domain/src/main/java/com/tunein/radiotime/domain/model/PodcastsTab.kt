package com.tunein.radiotime.domain.model

/**
 * [PodcastsTab] store data for Podcast screen
 */
data class PodcastsTab(
    val title: String?,
    val url: String?,
    val podcastCategories: MutableList<Category> = mutableListOf()
)