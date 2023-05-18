package com.tunein.radiotime.data.repository

import javax.inject.Inject

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.response.ResponseDto
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.domain.repository.MediaRepository

class MediaRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val audioDataDomainMapper: Mapper<String, ResponseDto>
) : MediaRepository {

    override suspend fun getAudioData(url: String): String = withContext(Dispatchers.IO) {
        val response = remoteDataSource.fetchRawDataByUrl(url)
        return@withContext audioDataDomainMapper.to(response)
    }
}
