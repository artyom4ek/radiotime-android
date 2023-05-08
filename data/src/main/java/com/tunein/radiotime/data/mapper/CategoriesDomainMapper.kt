package com.tunein.radiotime.data.mapper

import kotlin.random.Random

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.main.CategoriesItemDto
import com.tunein.radiotime.domain.model.CategoryItem

class CategoriesDomainMapper @Inject constructor() : Mapper<CategoryItem, CategoriesItemDto> {

    override fun from(i: CategoryItem?): CategoriesItemDto {
        TODO("Not yet implemented")
    }

    override fun to(o: CategoriesItemDto?): CategoryItem {
        return CategoryItem(
            title = o?.text ?: "",
            url = o?.url ?: "",
            count = Random.nextInt(10, 51) // TODO: should be implemented later
        )
    }
}