package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

import com.tunein.radiotime.common.utils.ContentType
import com.tunein.radiotime.data.entity.BodyDto
import com.tunein.radiotime.data.entity.ItemDto
import com.tunein.radiotime.data.parser.ResponseFields
import com.tunein.radiotime.data.parser.Parser
import com.tunein.radiotime.domain.model.BaseTab
import com.tunein.radiotime.domain.model.CategoryItems
import com.tunein.radiotime.domain.model.CategoryType

/**
 * [RawDataMapperImpl] converting raw data to [CategoryType] list.
 */
class RawDataMapperImpl @Inject constructor(
    private val json: Json,
    private val parser: Parser,
    private val audioTabDomainMapper: AudioTabDomainMapper,
    private val audioItemDomainMapper: AudioItemDomainMapper,
    private val gridTabDomainMapper: GridTabDomainMapper,
    private val gridItemDomainMapper: GridItemDomainMapper,
    private val listTabDomainMapper: ListTabDomainMapper,
    private val listItemDomainMapper: ListItemDomainMapper
) : RawDataMapper {

    override fun mapRawDataToDetails(items: List<JsonElement>?): List<CategoryType> {
        // Determine what type of raw data is in the input.
        return if (parser.checkIfChildrenExists(items)) {
            mapRawBody(items)
        } else {
            mapRawItems(items)
        }
    }

    // The method converts the raw data into a list of Tabs with child elements.
    private fun mapRawBody(bodyList: List<JsonElement>?): List<BaseTab> {
        if (bodyList == null) throw NullPointerException("List mustn't be null")

        val items = bodyList.filter {
            ResponseFields.CHILDREN.fieldName in it.jsonObject
        }

        return items.mapNotNull { rootItem ->
            val body = json.decodeFromJsonElement<BodyDto>(rootItem.jsonObject)
            val bodyChildren = body.children
            if (!bodyChildren.isNullOrEmpty()) {
                when (parser.itemAnalysis(bodyChildren[0])) {
                    ContentType.AudioList -> audioTabDomainMapper.to(rootItem.jsonObject)

                    ContentType.CategoryGrid -> gridTabDomainMapper.to(rootItem.jsonObject)

                    ContentType.CategoryList -> listTabDomainMapper.to(rootItem.jsonObject)

                    ContentType.Empty -> null
                }
            } else null
        }
    }

    // The method converts the raw data into a list of CategoryItems.
    private fun mapRawItems(itemList: List<JsonElement>?): List<CategoryItems> {
        if (itemList == null) throw NullPointerException("List mustn't be null")

        return itemList.mapNotNull { rootItem ->
            val itemDto = json.decodeFromJsonElement<ItemDto>(rootItem.jsonObject)
            when (parser.itemAnalysis(itemDto)) {
                ContentType.AudioList -> audioItemDomainMapper.to(itemDto)

                ContentType.CategoryGrid -> gridItemDomainMapper.to(itemDto)

                ContentType.CategoryList -> listItemDomainMapper.to(itemDto)

                ContentType.Empty -> null
            }
        }
    }
}