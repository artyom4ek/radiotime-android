package com.tunein.radiotime.domain.repository

import com.tunein.radiotime.domain.model.Category

interface PodcastsRepository {

    /**
     * Prepare initial data with Podcast categories
     */
    suspend fun getPodcastCategories(url: String): List<Category>
}