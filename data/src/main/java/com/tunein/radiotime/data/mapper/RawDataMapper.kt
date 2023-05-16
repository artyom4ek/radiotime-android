package com.tunein.radiotime.data.mapper

import kotlinx.serialization.json.JsonElement

import com.tunein.radiotime.domain.model.CategoryType

interface RawDataMapper {

    fun mapRawData(items: List<JsonElement>?): List<CategoryType>
}