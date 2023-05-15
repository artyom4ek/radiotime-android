package com.tunein.radiotime.domain.repository

import com.tunein.radiotime.domain.model.CategoryType
import com.tunein.radiotime.domain.model.InitialData

interface MainRepository {

    /**
     * Get initial data to initialize Main screens
     */
    suspend fun getInitialData(): InitialData

    /**
     * Get parsed data to initialize Details screen
     */
    suspend fun getParsedData(url: String): List<CategoryType>
}