package com.tunein.radiotime.data.repository

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.InitialDataResponseDto
import com.tunein.radiotime.data.entity.categoryDetails.BodyDto
import com.tunein.radiotime.data.entity.main.CategoriesItemDto
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.model.Category
import com.tunein.radiotime.domain.model.CategoryItem
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.repository.MainRepository

class MainRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val initialDataMapper: Mapper<InitialDataResponseDto, InitialData>,
    private val categoriesDomainMapper: Mapper<CategoryItem, CategoriesItemDto>,
    private val categoryDetailsDomainMapper: Mapper<Category, BodyDto>

) : MainRepository {

    override suspend fun getInitialData(): InitialData {
        val initialDataResponse = remoteDataSource.fetchInitialData()
        return initialDataMapper.from(initialDataResponse)
    }

    override suspend fun getCategoriesByUrl(url: String): List<CategoryItem> {
        val categoriesResponse = remoteDataSource.fetchCategoriesByUrl(url)
        return categoriesDomainMapper.toList(categoriesResponse.body)
    }

    override suspend fun getCategoryDetails(url: String): List<Category> {
        val categoryDetailsResponse = remoteDataSource.fetchDataWithChildren(url)
        return categoryDetailsDomainMapper.toList(categoryDetailsResponse.body)
    }
}