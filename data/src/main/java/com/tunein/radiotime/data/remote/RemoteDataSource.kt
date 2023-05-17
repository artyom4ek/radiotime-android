package com.tunein.radiotime.data.remote

import com.tunein.radiotime.data.entity.response.ResponseDto

interface RemoteDataSource {
    
    /**
     * Fetch raw data for mapping into various types
     */
    suspend fun fetchRawDataByUrl(url: String): ResponseDto
}