package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

import com.tunein.radiotime.common.qualifiers.IoDispatcher
import com.tunein.radiotime.domain.repository.PodcastsRepository
import com.tunein.radiotime.domain.model.GridTab

/**
 * [PodcastsUseCase] provides methods for retrieving podcasts data.
 *
 * @param ioDispatcher The CoroutineDispatcher for performing IO operations.
 * @param podcastsRepository The repository interface for accessing podcasts repository data.
 */
class PodcastsUseCase @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val podcastsRepository: PodcastsRepository
) {

    suspend fun getPodcastCategories(url: String): List<GridTab> = withContext(ioDispatcher) {
        return@withContext podcastsRepository.getPodcastCategories(url)
    }
}
