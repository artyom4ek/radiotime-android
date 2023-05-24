package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

import com.tunein.radiotime.common.qualifiers.IoDispatcher
import com.tunein.radiotime.domain.repository.MediaRepository

/**
 * [MediaUseCase] provides methods for retrieving media data.
 *
 * @param ioDispatcher The CoroutineDispatcher for performing IO operations.
 * @param mediaRepository The repository interface for accessing media repository data.
 */
class MediaUseCase @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val mediaRepository: MediaRepository
) {

    suspend fun getAudioData(url: String): String = withContext(ioDispatcher) {
        return@withContext mediaRepository.getAudioData(url)
    }
}
