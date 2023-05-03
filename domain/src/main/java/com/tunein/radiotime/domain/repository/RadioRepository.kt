package com.tunein.radiotime.domain.repository

import com.tunein.radiotime.domain.model.RadioStation

interface RadioRepository {

    /**
     * Prepare initial data with Radio stations
     */
    suspend fun getRadioStations(url: String): List<RadioStation>
}