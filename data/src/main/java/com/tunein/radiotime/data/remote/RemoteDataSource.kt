package com.tunein.radiotime.data.remote

import com.tunein.radiotime.data.entity.main.InitialDataResponseDto
import com.tunein.radiotime.data.entity.response.ResponseDto

interface RemoteDataSource {

    /**
     * Fetch initial data for parsing
     */
    suspend fun fetchInitialData(): InitialDataResponseDto

    suspend fun fetchRawDataByUrl(url: String): ResponseDto
}