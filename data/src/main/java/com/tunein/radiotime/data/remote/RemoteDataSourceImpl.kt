package com.tunein.radiotime.data.remote

import javax.inject.Inject

import com.tunein.radiotime.data.api.ApiService
import com.tunein.radiotime.data.entity.ResponseDto

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun fetchRawDataByUrl(url: String): ResponseDto {
        return apiService.fetchRawDataByUrl(url)
    }
}