package com.tunein.radiotime.data.repository

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.InitialDataResponseDto
import com.tunein.radiotime.data.entity.main.CategoriesItemDto
import com.tunein.radiotime.data.mapper.CategoriesDomainMapper
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.model.CategoryItem
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.repository.MainRepository

class MainRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val initialDataMapper: Mapper<InitialDataResponseDto, InitialData>,
    private val categoriesDomainMapper: Mapper<CategoryItem, CategoriesItemDto>

) : MainRepository {

    override suspend fun getInitialData(): InitialData {
        val initialDataResponse = remoteDataSource.fetchInitialData()
        return initialDataMapper.from(initialDataResponse)
    }

    override suspend fun getCategoriesByUrl(url: String): List<CategoryItem> {
        val categoriesResponse = remoteDataSource.fetchCategoriesByUrl(url)
        return categoriesDomainMapper.toList(categoriesResponse.body)
    }
}