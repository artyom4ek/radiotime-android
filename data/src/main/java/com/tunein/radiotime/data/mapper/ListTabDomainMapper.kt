package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.response.BodyDto
import com.tunein.radiotime.domain.model.ListItem
import com.tunein.radiotime.domain.model.ListTab

@OptIn(ExperimentalSerializationApi::class)
class ListTabDomainMapper @Inject constructor() : Mapper<ListTab, JsonElement> {

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    override fun from(i: ListTab?): JsonElement {
        TODO("Not yet implemented")
    }

    override fun to(o: JsonElement?): ListTab {
        if (o == null) throw Exception("Invalid JsonElement")

        val bodyDto = json.decodeFromJsonElement<BodyDto>(o)
        return ListTab(
            title = bodyDto.text ?: "",
            key = bodyDto.key,
            items = bodyDto.children?.map {
                ListItem(
                    title = it.text ?: "",
                    subTitle = it.subtext ?: "",
                    url = it.URL,
                    currentTrack = it.current_track ?: it.playing ?: "",
                    cover = it.image
                )
            } ?: emptyList()
        )
    }
}