package com.tunein.radiotime.domain.repository

interface MainRepository {

    /**
     * Get initial data to initialize screens
     */
    suspend fun getInitialData(): Map<String, Any>
}