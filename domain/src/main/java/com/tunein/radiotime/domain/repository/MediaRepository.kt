package com.tunein.radiotime.domain.repository

interface MediaRepository {
    suspend fun getAudioData(url: String): String
}