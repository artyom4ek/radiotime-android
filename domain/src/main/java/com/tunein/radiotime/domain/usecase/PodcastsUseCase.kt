package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import com.tunein.radiotime.domain.repository.PodcastsRepository
import com.tunein.radiotime.domain.model.Category

class PodcastsUseCase @Inject constructor(
    private val podcastsRepository: PodcastsRepository
) {

    suspend fun getPodcastCategories(url: String): List<Category> {
        return podcastsRepository.getPodcastCategories(url)
    }
}
