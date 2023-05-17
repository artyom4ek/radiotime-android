package com.tunein.radiotime.domain.repository

import com.tunein.radiotime.domain.model.GridTab

interface PodcastsRepository {

    /**
     * Prepare initial data with Podcast categories
     */
    suspend fun getPodcastCategories(url: String): List<GridTab>
}