package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import com.tunein.radiotime.domain.model.RadioStation
import com.tunein.radiotime.domain.repository.RadioRepository

class RadioUseCase @Inject constructor(
    private val radioRepository: RadioRepository
) {

    suspend fun getRadioStations(url: String): List<RadioStation> {
        return radioRepository.getRadioStations(url)
    }
}
