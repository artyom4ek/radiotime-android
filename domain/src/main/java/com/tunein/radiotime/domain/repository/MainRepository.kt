package com.tunein.radiotime.domain.repository

import kotlinx.coroutines.flow.Flow

import com.tunein.radiotime.common.utils.Resource
import com.tunein.radiotime.domain.model.InitialData

/**
 * [MainRepository] interface for retrieving data related to the Main screens.
 */
interface MainRepository {

    /**
     * Get initial data to initialize Main screens.
     */
    suspend fun getInitialData(): Flow<Resource<InitialData>>
}