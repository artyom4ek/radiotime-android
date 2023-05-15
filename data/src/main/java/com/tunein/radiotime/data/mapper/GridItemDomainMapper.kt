package com.tunein.radiotime.data.mapper

import kotlin.random.Random

import javax.inject.Inject

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.response.ItemDto
import com.tunein.radiotime.domain.model.GridItem

@OptIn(ExperimentalSerializationApi::class)
class GridItemDomainMapper @Inject constructor() : Mapper<GridItem, JsonElement> {

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    override fun from(i: GridItem?): JsonElement {
        TODO("Not yet implemented")
    }

    override fun to(o: JsonElement?): GridItem {
        if (o == null) throw Exception("Invalid JsonElement")

        val itemDto = json.decodeFromJsonElement<ItemDto>(o)
        return GridItem(
            title = itemDto.text ?: "",
            url = itemDto.URL ?: "",
            count = Random.nextInt(10, 51) // TODO: should be implemented later
        )
    }
}