package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import com.tunein.radiotime.domain.repository.PodcastsRepository
import com.tunein.radiotime.domain.model.Category
import com.tunein.radiotime.domain.model.CategoryType
import com.tunein.radiotime.domain.repository.MainRepository

class PodcastsUseCase @Inject constructor(
    private val mainRepository: MainRepository,
    private val podcastsRepository: PodcastsRepository
) {

    suspend fun getPodcastCategories(url: String): List<Category> {
        return podcastsRepository.getPodcastCategories(url)
    }

    suspend fun getParsedData(url: String): List<CategoryType> {
        return mainRepository.getParsedData(url)
    }
}
