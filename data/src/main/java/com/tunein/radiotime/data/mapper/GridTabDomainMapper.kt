package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.response.BodyDto
import com.tunein.radiotime.domain.model.GridItem
import com.tunein.radiotime.domain.model.GridTab

@OptIn(ExperimentalSerializationApi::class)
class GridTabDomainMapper @Inject constructor() : Mapper<GridTab, JsonElement> {

    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    override fun from(i: GridTab?): JsonElement {
        TODO("Not yet implemented")
    }

    override fun to(o: JsonElement?): GridTab {
        if (o == null) throw Exception("Invalid JsonElement")

        val bodyDto = json.decodeFromJsonElement<BodyDto>(o)
        return GridTab(
            title = bodyDto.text ?: "",
            key = bodyDto.key,
            items = bodyDto.children?.map {
                GridItem(
                    title = it.text ?: "",
                    url = it.URL ?: "",
                )
            } ?: emptyList()
        )
    }
}