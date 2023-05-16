package com.tunein.radiotime.data.repository

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.main.InitialDataResponseDto
import com.tunein.radiotime.data.mapper.RawDataMapper
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.model.CategoryType
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.repository.MainRepository

class MainRepositoryImpl @Inject constructor(
    private val rawDataMapper: RawDataMapper,
    private val remoteDataSource: RemoteDataSource,
    private val initialDataMapper: Mapper<InitialDataResponseDto, InitialData>
) : MainRepository {

    override suspend fun getInitialData(): InitialData {
        val initialDataResponse = remoteDataSource.fetchInitialData()
        return initialDataMapper.from(initialDataResponse)
    }

    override suspend fun getParsedData(url: String): List<CategoryType> {
        val data = remoteDataSource.fetchRawDataByUrl(url).body
        return rawDataMapper.mapRawData(data)
    }
}