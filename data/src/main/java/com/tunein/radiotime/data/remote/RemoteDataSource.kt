package com.tunein.radiotime.data.remote

import com.tunein.radiotime.data.entity.main.InitialDataResponseDto
import com.tunein.radiotime.data.entity.response.ResponseDto

interface RemoteDataSource {

    /**
     * Fetch initial data for parsing
     */
    suspend fun fetchInitialData(): InitialDataResponseDto

    /**
     * Fetch raw data for mapping into various types
     */
    suspend fun fetchRawDataByUrl(url: String): ResponseDto
}