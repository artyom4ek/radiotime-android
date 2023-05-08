package com.tunein.radiotime.data.remote

import com.tunein.radiotime.data.entity.InitialDataResponseDto
import com.tunein.radiotime.data.entity.main.CategoriesResponseDto

interface RemoteDataSource {

    /**
     * Fetch initial data for parsing
     */
    suspend fun fetchInitialData(): InitialDataResponseDto

    /**
     * Fetch Categories by URL
     */
    suspend fun fetchCategoriesByUrl(url: String): CategoriesResponseDto
}