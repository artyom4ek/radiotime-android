package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.response.BodyDto
import com.tunein.radiotime.domain.model.AudioTab
import com.tunein.radiotime.domain.model.AudioItem

@OptIn(ExperimentalSerializationApi::class)
class AudioTabDomainMapper @Inject constructor() : Mapper<AudioTab, JsonElement> {

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    override fun from(i: AudioTab?): JsonElement {
        TODO("Not yet implemented")
    }

    override fun to(o: JsonElement?): AudioTab {
        if (o == null) throw Exception("Invalid JsonElement")

        val bodyDto = json.decodeFromJsonElement<BodyDto>(o)
        return AudioTab(
            title = bodyDto.text ?: "",
            key = bodyDto.key,
            items = bodyDto.children?.map {
                AudioItem(
                    title = it.text ?: "",
                    subTitle = it.subtext ?: "",
                    url = it.URL,
                    track = it.current_track ?: it.playing ?: "",
                    cover = it.image
                )
            } ?: emptyList()
        )
    }
}