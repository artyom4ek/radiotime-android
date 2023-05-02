package com.tunein.radiotime.data.remote

import javax.inject.Inject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import com.tunein.radiotime.data.api.ApiService

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun fetchInitialData(): List<Any> = withContext(Dispatchers.IO) {
        apiService.fetchInitialData()
        return@withContext emptyList()
    }
}