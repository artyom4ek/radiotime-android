package com.tunein.radiotime.domain.repository

/**
 * [MediaRepository] interface for retrieving Audio data.
 */
interface MediaRepository {

    /**
     * Retrieves audio data from the specified URL.
     */
    suspend fun getAudioData(url: String): String
}