package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import com.tunein.radiotime.domain.repository.MediaRepository

class MediaUseCase @Inject constructor(
    private val mediaRepository: MediaRepository
) {

    suspend fun getAudioData(url: String): String {
        return mediaRepository.getAudioData(url)
    }
}
