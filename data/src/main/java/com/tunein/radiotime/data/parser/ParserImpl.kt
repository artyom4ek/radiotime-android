package com.tunein.radiotime.data.parser

import javax.inject.Inject

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

import com.tunein.radiotime.common.utils.ContentType
import com.tunein.radiotime.data.entity.ItemDto

/**
 * [ParserImpl] contains the raw data parsing logic.
 */
class ParserImpl @Inject constructor() : Parser {

    override fun checkIfChildrenExists(bodyList: List<JsonElement>?): Boolean {
        if (bodyList == null) throw NullPointerException("List mustn't be null")

        // Checks for the presence of child elements for the entire list.
        return bodyList.any { ResponseFields.CHILDREN.name in it.jsonObject }
    }

    /* The method determines the content type according to a certain pattern,
     * which is determined by parameters and keys.
     */
    override fun itemAnalysis(itemDto: ItemDto): ContentType {
        if (
            itemDto.type == ResponseKeys.TEXT.key
        ) {
            return ContentType.Empty
        } else if (
            itemDto.type == ResponseKeys.AUDIO.key
        ) {
            return ContentType.AudioList
        } else if (
            itemDto.type == ResponseKeys.LINK.key
            && itemDto.item.isNullOrEmpty()
        ) {
            return ContentType.CategoryGrid
        } else if (
            itemDto.type == ResponseKeys.LINK.key
            && (itemDto.item == ResponseKeys.SHOW.key
                    || itemDto.item == ResponseKeys.STATION.key
                    || itemDto.item == ResponseKeys.LOCAL.key)
        ) {
            return ContentType.CategoryList
        }

        return ContentType.Empty
    }
}