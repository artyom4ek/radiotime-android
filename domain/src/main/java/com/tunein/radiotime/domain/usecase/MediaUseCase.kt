package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

import com.tunein.radiotime.common.qualifiers.IoDispatcher
import com.tunein.radiotime.domain.repository.MediaRepository

class MediaUseCase @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val mediaRepository: MediaRepository
) {

    suspend fun getAudioData(url: String): String = withContext(ioDispatcher) {
        return@withContext mediaRepository.getAudioData(url)
    }
}
