package com.tunein.radiotime.data.remote

import javax.inject.Inject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import com.tunein.radiotime.data.api.ApiService
import com.tunein.radiotime.data.entity.InitialDataResponseDto
import com.tunein.radiotime.data.entity.categoryDetails.ResponseWithChildrenDto
import com.tunein.radiotime.data.entity.main.CategoriesResponseDto
import com.tunein.radiotime.data.entity.response.ResponseDto

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : RemoteDataSource {

    override suspend fun fetchInitialData(): InitialDataResponseDto = withContext(Dispatchers.IO) {
        return@withContext apiService.fetchInitialData()
    }

    override suspend fun fetchCategoriesByUrl(url: String): CategoriesResponseDto =
        withContext(Dispatchers.IO) {
            return@withContext apiService.fetchCategories(url)
        }

    override suspend fun fetchDataWithChildren(url: String): ResponseWithChildrenDto =
        withContext(Dispatchers.IO) {
            return@withContext apiService.fetchDataWithChildren(url)
        }

    override suspend fun fetchRawDataByUrl(url: String): ResponseDto =
        withContext(Dispatchers.IO) {
            return@withContext apiService.fetchRawDataByUrl(url)
        }
}