package com.tunein.radiotime.data.parser

import javax.inject.Inject

import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject

import com.tunein.radiotime.common.utils.ContentType
import com.tunein.radiotime.data.entity.ItemDto

class ParserImpl @Inject constructor() : Parser {

    override fun checkIfChildrenExists(bodyList: List<JsonElement>?): Boolean {
        if (bodyList == null) throw NullPointerException("List mustn't be null")

        return bodyList.any { ResponseFields.CHILDREN.fieldName in it.jsonObject }
    }

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
            && !itemDto.guideId.isNullOrEmpty()
        ) {
            return ContentType.CategoryGrid
        } else if (
            itemDto.type == ResponseKeys.LINK.key
            && (itemDto.item == ResponseKeys.SHOW.key
                    || itemDto.item == ResponseKeys.STATION.key
                    || itemDto.item == ResponseKeys.LOCAL.key
                    || !itemDto.key.isNullOrEmpty())
        ) {
            return ContentType.CategoryList
        }

        return ContentType.Empty
    }
}