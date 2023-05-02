package com.tunein.radiotime.domain.model

/**
 * [PodcastTab] store data for Podcast screen
 */
data class PodcastTab(
    val title: String?,
    val url: String?,
    val podcastCategories: List<Category> = listOf()
)