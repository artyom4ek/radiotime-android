package com.tunein.radiotime.domain.usecase

import javax.inject.Inject

import com.tunein.radiotime.domain.model.Category
import com.tunein.radiotime.domain.repository.MainRepository

class CategoryDetailsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    suspend fun getCategoryDetails(url: String): List<Category> {
        return mainRepository.getCategoryDetails(url)
    }
}