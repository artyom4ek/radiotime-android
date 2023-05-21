package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.BodyDto
import com.tunein.radiotime.domain.model.GridTab

class GridTabDomainMapper @Inject constructor(
    private val json: Json,
    private val gridItemDomainMapper: GridItemDomainMapper

) : Mapper<GridTab, JsonElement> {

    override fun from(i: GridTab?): JsonElement {
        TODO("Not yet implemented")
    }

    override fun to(o: JsonElement?): GridTab {
        if (o == null) throw Exception("Invalid JsonElement")

        val bodyDto = json.decodeFromJsonElement<BodyDto>(o)
        return GridTab(
            title = bodyDto.text ?: "",
            key = bodyDto.key,
            items = bodyDto.children?.mapNotNull {
                gridItemDomainMapper.to(it)
            } ?: emptyList()
        )
    }
}