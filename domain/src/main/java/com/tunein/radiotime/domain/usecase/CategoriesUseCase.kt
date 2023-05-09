package com.tunein.radiotime.domain.usecase

import com.tunein.radiotime.domain.model.CategoryItem
import javax.inject.Inject

import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.repository.MainRepository

class CategoriesUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    suspend fun getCategoriesByUrl(url: String): List<CategoryItem> {
        return mainRepository.getCategoriesByUrl(url)
    }
}