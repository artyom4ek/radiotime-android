package com.tunein.radiotime.domain.repository

import com.tunein.radiotime.domain.model.Category
import com.tunein.radiotime.domain.model.CategoryItem
import com.tunein.radiotime.domain.model.CategoryType
import com.tunein.radiotime.domain.model.InitialData

interface MainRepository {

    /**
     * Get initial data to initialize screens
     */
    suspend fun getInitialData(): InitialData

    /**
     * Get Category details for specific category
     */
    suspend fun getCategoryDetails(url: String): List<Category>

    suspend fun getParsedData(url: String): List<CategoryType>
}