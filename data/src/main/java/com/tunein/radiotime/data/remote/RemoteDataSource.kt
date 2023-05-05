package com.tunein.radiotime.data.remote

import com.tunein.radiotime.data.entity.InitialDataResponseDto

interface RemoteDataSource {

    /**
     * Fetch initial data for parsing
     */
    suspend fun fetchInitialData(): InitialDataResponseDto
}