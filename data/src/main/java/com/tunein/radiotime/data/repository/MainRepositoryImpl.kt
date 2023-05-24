package com.tunein.radiotime.data.repository

import javax.inject.Inject

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.common.utils.Constants
import com.tunein.radiotime.common.utils.Resource
import com.tunein.radiotime.data.entity.ResponseDto
import com.tunein.radiotime.data.mapper.RawDataMapper
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.model.CategoryType
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.repository.MainRepository

/**
 * [MainRepositoryImpl] implements the logic for providing initial data.
 */
class MainRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val initialDataMapper: Mapper<InitialData, ResponseDto>,
    private val rawDataToDetailsMapper: RawDataMapper,
) : MainRepository {

    // Get initial data to initialize screens.
    override suspend fun getInitialData(): Flow<Resource<InitialData>> = flow {
        try {
            val response = remoteDataSource.fetchRawDataByUrl(Constants.BASE_URL)
            emit(Resource.Success(initialDataMapper.to(response)))
        } catch (ex: Exception) {
            emit(Resource.Error(ex.message ?: "Unknown error"))
        }
    }

    // Get data for the Details screen.
    override suspend fun getDetailsData(url: String): Flow<Resource<List<CategoryType>>> = flow {
        try {
            val rawData = remoteDataSource.fetchRawDataByUrl(url).body
            val detailsData = rawDataToDetailsMapper.mapRawDataToDetails(rawData)
            if (detailsData.isEmpty()) {
                emit(Resource.Empty)
            } else {
                emit(Resource.Success(rawDataToDetailsMapper.mapRawDataToDetails(rawData)))
            }
        } catch (ex: Exception) {
            emit(Resource.Empty)
            emit(Resource.Error(ex.message ?: "Unknown error"))
        }
    }
}