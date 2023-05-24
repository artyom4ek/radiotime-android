package com.tunein.radiotime.domain.repository

import com.tunein.radiotime.domain.model.GridTab

/**
 * [PodcastsRepository] interface for retrieving data related to the Podcasts screens.
 */
interface PodcastsRepository {

    /**
     * Prepare initial data with Podcast categories.
     */
    suspend fun getPodcastCategories(url: String): List<GridTab>
}