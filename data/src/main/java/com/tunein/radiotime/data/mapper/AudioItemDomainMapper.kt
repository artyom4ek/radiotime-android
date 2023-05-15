package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.response.ItemDto
import com.tunein.radiotime.domain.model.AudioItem

@OptIn(ExperimentalSerializationApi::class)
class AudioItemDomainMapper @Inject constructor() : Mapper<AudioItem, JsonElement> {

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    override fun from(i: AudioItem?): JsonElement {
        TODO("Not yet implemented")
    }

    override fun to(o: JsonElement?): AudioItem {
        if (o == null) throw Exception("Invalid JsonElement")

        val itemDto = json.decodeFromJsonElement<ItemDto>(o)
        return AudioItem(
            title = itemDto.text ?: "",
            subTitle = itemDto.subtext ?: "",
            url = itemDto.URL,
            track = itemDto.current_track ?: itemDto.playing ?: "",
            cover = itemDto.image
        )
    }
}