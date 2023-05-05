package com.tunein.radiotime.data.remote

import javax.inject.Inject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import com.tunein.radiotime.data.api.ApiService
import com.tunein.radiotime.data.entity.InitialDataResponseDto

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun fetchInitialData(): InitialDataResponseDto = withContext(Dispatchers.IO) {
        return@withContext apiService.fetchInitialData()
    }
}