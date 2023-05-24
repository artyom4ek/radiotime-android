package com.tunein.radiotime.data.repository

import javax.inject.Inject

import kotlinx.serialization.json.JsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.model.GridTab
import com.tunein.radiotime.domain.repository.PodcastsRepository

/**
 * [PodcastsRepositoryImpl] implements the logic for providing data for Podcasts screen.
 */
class PodcastsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val podcastsDomainMapper: Mapper<GridTab, JsonElement>
) : PodcastsRepository {

    // Get a list of podcast categories.
    override suspend fun getPodcastCategories(url: String): List<GridTab> {
        val data = remoteDataSource.fetchRawDataByUrl(url).body
        return podcastsDomainMapper.toList(data)
    }
}