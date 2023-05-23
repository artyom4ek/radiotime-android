package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

import com.tunein.radiotime.common.qualifiers.IoDispatcher
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.repository.RadioRepository

class RadioUseCase @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val radioRepository: RadioRepository
) {

    suspend fun getRadioStations(url: String): List<AudioItem> = withContext(ioDispatcher) {
        return@withContext radioRepository.getRadioStations(url)
    }
}
