package com.tunein.radiotime.data.repository

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.ResponseDto
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.repository.MediaRepository

class MediaRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val audioDataDomainMapper: Mapper<String, ResponseDto>
) : MediaRepository {

    override suspend fun getAudioData(url: String): String {
        val response = remoteDataSource.fetchRawDataByUrl(url)
        return audioDataDomainMapper.to(response)
    }
}
