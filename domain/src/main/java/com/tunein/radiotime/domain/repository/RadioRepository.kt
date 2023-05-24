package com.tunein.radiotime.domain.repository

import com.tunein.radiotime.domain.model.AudioItem

/**
 * [RadioRepository] interface for retrieving data related to the Radio screens.
 */
interface RadioRepository {

    /**
     * Prepare initial data with Radio stations.
     */
    suspend fun getRadioStations(url: String): List<AudioItem>
}