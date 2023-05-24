package com.tunein.radiotime.data.repository

import javax.inject.Inject

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import com.tunein.radiotime.common.utils.Resource
import com.tunein.radiotime.data.mapper.RawDataMapper
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.model.CategoryType
import com.tunein.radiotime.domain.repository.DetailsRepository

/**
 * [DetailsRepositoryImpl] implements the logic for providing details data.
 */
class DetailsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val rawDataToDetailsMapper: RawDataMapper,
) : DetailsRepository {

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