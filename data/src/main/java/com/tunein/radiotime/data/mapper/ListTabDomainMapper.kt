package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.BodyDto
import com.tunein.radiotime.data.entity.ItemDto
import com.tunein.radiotime.domain.model.ListItem
import com.tunein.radiotime.domain.model.ListTab

/**
 * [ListTabDomainMapper] responsible for mapping a [JsonElement] to a [ListTab].
 */
class ListTabDomainMapper @Inject constructor(
    private val json: Json,
    private val listItemDomainMapper: ListItemDomainMapper
) : Mapper<ListTab, JsonElement> {

    override fun to(o: JsonElement?): ListTab {
        if (o == null) throw Exception("Invalid JsonElement")

        val bodyDto = json.decodeFromJsonElement<BodyDto>(o)
        return ListTab(
            title = bodyDto.text ?: "",
            items = bodyDto.children?.mapNotNull {
                listItemDomainMapper.to(it)
            } ?: emptyList()
        )
    }
}