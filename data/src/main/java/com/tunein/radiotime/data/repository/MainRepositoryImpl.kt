package com.tunein.radiotime.data.repository

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.common.network.Constants
import com.tunein.radiotime.data.entity.response.ResponseDto
import com.tunein.radiotime.data.mapper.RawDataMapper
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.model.CategoryType
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.repository.MainRepository

class MainRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val initialDataMapper: Mapper<InitialData, ResponseDto>,
    private val rawDataToDetailsMapper: RawDataMapper,
) : MainRepository {

    override suspend fun getInitialData(): InitialData {
        val response = remoteDataSource.fetchRawDataByUrl(Constants.BASE_URL)
        return initialDataMapper.to(response)
    }

    override suspend fun getDetailsData(url: String): List<CategoryType> {
        val rawData = remoteDataSource.fetchRawDataByUrl(url).body
        return rawDataToDetailsMapper.mapRawDataToDetails(rawData)
    }
}