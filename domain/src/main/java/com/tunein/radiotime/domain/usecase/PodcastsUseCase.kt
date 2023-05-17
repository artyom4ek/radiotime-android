package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import com.tunein.radiotime.domain.repository.PodcastsRepository
import com.tunein.radiotime.domain.model.GridTab

class PodcastsUseCase @Inject constructor(
    private val podcastsRepository: PodcastsRepository
) {

    suspend fun getPodcastCategories(url: String): List<GridTab> {
        return podcastsRepository.getPodcastCategories(url)
    }
}
