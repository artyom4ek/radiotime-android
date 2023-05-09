package com.tunein.radiotime.domain.repository

import com.tunein.radiotime.domain.model.CategoryItem
import com.tunein.radiotime.domain.model.InitialData

interface MainRepository {

    /**
     * Get initial data to initialize screens
     */
    suspend fun getInitialData(): InitialData

    /**
     * Get Categories by URL
     */
    suspend fun getCategoriesByUrl(url: String): List<CategoryItem>
}