package com.tunein.radiotime.data.repository

import javax.inject.Inject

import kotlinx.serialization.json.JsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.AudioTab
import com.tunein.radiotime.domain.repository.RadioRepository

/**
 * [RadioRepositoryImpl] implements the logic for providing data for Radio screen.
 */
class RadioRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val audioTabDomainMapper: Mapper<AudioTab, JsonElement>
) : RadioRepository {

    // Get a list of local radio stations.
    override suspend fun getRadioStations(url: String): List<AudioItem> {
        val data = remoteDataSource.fetchRawDataByUrl(url).body
        val radioTabs = audioTabDomainMapper.toList(data)
        return if (radioTabs.isNotEmpty()) {
            audioTabDomainMapper.toList(data)[0].items
        } else {
            emptyList()
        }
    }
}