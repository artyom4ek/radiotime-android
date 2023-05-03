package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import com.tunein.radiotime.domain.repository.MainRepository
import com.tunein.radiotime.domain.model.InitialData

class MainUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    suspend fun getInitialData(): InitialData {
        return mainRepository.getInitialData()
    }
}
