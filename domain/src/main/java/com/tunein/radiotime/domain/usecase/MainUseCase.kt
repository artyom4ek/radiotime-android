package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import com.tunein.radiotime.domain.repository.MainRepository

class MainUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    suspend fun getInitialData() {
        mainRepository.getInitialData()
    }
}
