package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.response.ItemDto
import com.tunein.radiotime.domain.model.ListItem

@OptIn(ExperimentalSerializationApi::class)
class ListItemDomainMapper @Inject constructor() : Mapper<ListItem, JsonElement> {

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    override fun from(i: ListItem?): JsonElement {
        TODO("Not yet implemented")
    }

    override fun to(o: JsonElement?): ListItem {
        if (o == null) throw Exception("Invalid JsonElement")

        val itemDto = json.decodeFromJsonElement<ItemDto>(o)
        return ListItem(
            title = itemDto.text ?: "",
            subTitle = itemDto.text ?: "",
            currentTrack = itemDto.current_track,
            url = itemDto.URL ?: "",
            cover = itemDto.image,
        )
    }
}