package com.tunein.radiotime.data.remote

import com.tunein.radiotime.data.entity.ResponseDto

interface RemoteDataSource {

    /**
     * Fetch initial data for parsing
     */
    suspend fun fetchInitialData(): ResponseDto
}