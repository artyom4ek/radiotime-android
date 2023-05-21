package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import kotlinx.coroutines.flow.Flow

import com.tunein.radiotime.common.utils.Resource
import com.tunein.radiotime.domain.model.CategoryType
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.repository.MainRepository

class MainUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    suspend fun getInitialData(): Flow<Resource<InitialData>> {
        return mainRepository.getInitialData()
    }

    suspend fun getDetailsData(url: String): Flow<Resource<List<CategoryType>>> {
        return mainRepository.getDetailsData(url)
    }
}
