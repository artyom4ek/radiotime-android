package com.tunein.radiotime.data.remote

import com.tunein.radiotime.data.entity.ResponseDto

/**
 * [RemoteDataSource] contains methods for getting data from the server.
 */
interface RemoteDataSource {

    /**
     * Fetch raw data for mapping into various types.
     */
    suspend fun fetchRawDataByUrl(url: String): ResponseDto
}