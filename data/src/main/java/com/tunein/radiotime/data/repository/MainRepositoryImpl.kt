package com.tunein.radiotime.data.repository

import javax.inject.Inject

import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.repository.MainRepository

class MainRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : MainRepository {

    override suspend fun getInitialData(): Map<String, Any> {
        val initialData = remoteDataSource.fetchInitialData()
        return emptyMap()
    }
}