package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import com.tunein.radiotime.domain.model.CategoryType
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.repository.MainRepository

class MainUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    suspend fun getInitialData(): InitialData {
        return mainRepository.getInitialData()
    }

    suspend fun getDetailsData(url: String): List<CategoryType> {
        return mainRepository.getDetailsData(url)
    }
}
