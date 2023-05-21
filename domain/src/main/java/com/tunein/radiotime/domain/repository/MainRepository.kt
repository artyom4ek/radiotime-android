package com.tunein.radiotime.domain.repository

import kotlinx.coroutines.flow.Flow

import com.tunein.radiotime.domain.model.CategoryType
import com.tunein.radiotime.domain.model.InitialData

interface MainRepository {

    /**
     * Get initial data to initialize Main screens
     */
    suspend fun getInitialData(): Flow<com.tunein.radiotime.common.utils.Resource<InitialData>>

    /**
     * Get details data to initialize Details screen
     */
    suspend fun getDetailsData(url: String): List<CategoryType>
}