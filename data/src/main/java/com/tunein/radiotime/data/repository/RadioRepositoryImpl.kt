package com.tunein.radiotime.data.repository

import javax.inject.Inject

import com.tunein.radiotime.data.mapper.AudioTabDomainMapper
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.repository.RadioRepository

class RadioRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val audioTabDomainMapper: AudioTabDomainMapper
) : RadioRepository {

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