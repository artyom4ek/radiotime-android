package com.tunein.radiotime.data.repository

import javax.inject.Inject

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.common.utils.ContentType
import com.tunein.radiotime.data.parser.Parser
import com.tunein.radiotime.data.entity.InitialDataResponseDto
import com.tunein.radiotime.data.entity.categoryDetails.BodyDto
import com.tunein.radiotime.data.entity.main.CategoriesItemDto
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.model.AudioTab
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.Category
import com.tunein.radiotime.domain.model.GridItem
import com.tunein.radiotime.domain.model.CategoryItem
import com.tunein.radiotime.domain.model.ListItem
import com.tunein.radiotime.domain.model.CategoryType
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.model.GridTab
import com.tunein.radiotime.domain.model.ListTab
import com.tunein.radiotime.domain.repository.MainRepository

class MainRepositoryImpl @Inject constructor(
    private val parser: Parser,
    private val remoteDataSource: RemoteDataSource,
    private val initialDataMapper: Mapper<InitialDataResponseDto, InitialData>,
    private val categoriesDomainMapper: Mapper<CategoryItem, CategoriesItemDto>,
    private val categoryDetailsDomainMapper: Mapper<Category, BodyDto>,
    private val gridTabDomainMapper: Mapper<GridTab, JsonElement>,
    private val gridItemDomainMapper: Mapper<GridItem, JsonElement>,
    private val listTabDomainMapper: Mapper<ListTab, JsonElement>,
    private val listItemDomainMapper: Mapper<ListItem, JsonElement>,
    private val audioTabDomainMapper: Mapper<AudioTab, JsonElement>,
    private val audioItemDomainMapper: Mapper<AudioItem, JsonElement>
) : MainRepository {

    override suspend fun getInitialData(): InitialData {
        val initialDataResponse = remoteDataSource.fetchInitialData()
        return initialDataMapper.from(initialDataResponse)
    }

    override suspend fun getCategoriesByUrl(url: String): List<CategoryItem> {
        val categoriesResponse = remoteDataSource.fetchCategoriesByUrl(url)
        return categoriesDomainMapper.toList(categoriesResponse.body)
    }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getCategoryDetails(url: String): List<Category> {
        return emptyList()
    }

    override suspend fun getParsedData(url: String): List<CategoryType> {
        val data = remoteDataSource.fetchRawDataByUrl(url).body
        val response = parser.responseAnalysis(data)
        val contentType = response.first
        val hasChildren = response.second
        return when (contentType) {
            ContentType.AudioList -> {
                if (hasChildren) {
                    audioTabDomainMapper.toList(data)
                } else {
                    audioItemDomainMapper.toList(data)
                }
            }

            ContentType.CategoryGrid -> {
                if (hasChildren) {
                    gridTabDomainMapper.toList(data)
                } else {
                    gridItemDomainMapper.toList(data)
                }
            }

            ContentType.CategoryList -> {
                if (hasChildren) {
                    listTabDomainMapper.toList(data)
                } else {
                    listItemDomainMapper.toList(data)
                }
            }

            ContentType.Empty -> {
                emptyList()
            }
        }
    }
}