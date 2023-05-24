package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

import com.tunein.radiotime.common.qualifiers.IoDispatcher
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.repository.RadioRepository

/**
 * [RadioUseCase] provides methods for retrieving podcasts data.
 *
 * @param ioDispatcher The CoroutineDispatcher for performing IO operations.
 * @param radioRepository The repository interface for accessing radio repository data.
 */
class RadioUseCase @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val radioRepository: RadioRepository
) {

    suspend fun getRadioStations(url: String): List<AudioItem> = withContext(ioDispatcher) {
        return@withContext radioRepository.getRadioStations(url)
    }
}
