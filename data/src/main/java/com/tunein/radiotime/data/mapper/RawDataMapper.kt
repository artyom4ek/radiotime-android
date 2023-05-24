package com.tunein.radiotime.data.mapper

import kotlinx.serialization.json.JsonElement

import com.tunein.radiotime.domain.model.CategoryType

/**
 * The [RawDataMapper] interface defines a contract for mapping raw data represented
 * as a list of [JsonElement] objects to a list of [CategoryType] objects.
 * [CategoryType] is the root interface for several categories of data.
 */
interface RawDataMapper {

    // Mapping raw data to category type.
    fun mapRawDataToDetails(items: List<JsonElement>?): List<CategoryType>
}