package com.tunein.radiotime.domain.repository

import kotlinx.coroutines.flow.Flow

import com.tunein.radiotime.common.utils.Resource
import com.tunein.radiotime.domain.model.CategoryType

/**
 * [DetailsRepository] interface for retrieving data related to the Details screens.
 */
interface DetailsRepository {

    /**
     * Get details data to initialize Details screen.
     */
    suspend fun getDetailsData(url: String): Flow<Resource<List<CategoryType>>>
}