package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.BodyDto
import com.tunein.radiotime.domain.model.AudioTab

class AudioTabDomainMapper @Inject constructor(
    private val json: Json,
    private val audioItemDomainMapper: AudioItemDomainMapper
) : Mapper<AudioTab, JsonElement> {

    override fun from(i: AudioTab?): JsonElement {
        TODO("Not yet implemented")
    }

    override fun to(o: JsonElement?): AudioTab {
        if (o == null) throw Exception("Invalid JsonElement")

        val bodyDto = json.decodeFromJsonElement<BodyDto>(o)
        return AudioTab(
            title = bodyDto.text ?: "",
            key = bodyDto.key,
            items = bodyDto.children?.mapNotNull {
                audioItemDomainMapper.to(it)
            } ?: emptyList()
        )
    }
}