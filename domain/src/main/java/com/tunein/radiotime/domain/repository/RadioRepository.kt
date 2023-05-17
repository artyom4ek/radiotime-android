package com.tunein.radiotime.domain.repository

import com.tunein.radiotime.domain.model.AudioItem

interface RadioRepository {

    /**
     * Prepare initial data with Radio stations
     */
    suspend fun getRadioStations(url: String): List<AudioItem>
}