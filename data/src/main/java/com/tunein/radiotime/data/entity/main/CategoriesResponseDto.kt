package com.tunein.radiotime.data.entity.main

import kotlinx.serialization.Serializable

@Serializable
data class CategoriesResponseDto(
    val body: List<CategoriesItemDto>,
)