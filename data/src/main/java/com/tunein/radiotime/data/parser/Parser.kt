package com.tunein.radiotime.data.parser

import javax.inject.Inject

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

import com.tunein.radiotime.common.utils.ContentType
import com.tunein.radiotime.data.entity.response.BodyDto
import com.tunein.radiotime.data.entity.response.ItemDto

enum class BodyFields(val fieldName: String) {
    CHILDREN("children"),
    TYPE("type"),
    ITEM("item")
}

enum class BodyWithChildrenKeys(val key: String) {
    TOPIC("topic"),
    SHOWS("shows"),
}

enum class BodyFieldTypes(val typeName: String) {
    LINK("link"),
    TOPICS("topics"),
    TOPIC("topic"),
    SHOW("show"),
    SHOWS("shows"),
    AUDIO("audio"),
    STATIONS("stations"),
    STATION("station"),
    RELATED("related"),
    LOCAL("local"),
    TEXT("text"),
    NEXT_SHOWS("nextShows"),
    NEXT_STATIONS("nextStations")
}

@OptIn(ExperimentalSerializationApi::class)
class Parser @Inject constructor() {
    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    fun responseAnalysis(body: List<JsonElement>?): Pair<ContentType, Boolean> {
        if (body.isNullOrEmpty()) return Pair(ContentType.Empty, false)

        val rootItem = body[0].jsonObject
        if (BodyFields.CHILDREN.fieldName in rootItem) {
            val bodyDto = json.decodeFromJsonElement<BodyDto>(rootItem)
            if (
                bodyDto.key == BodyFieldTypes.SHOWS.typeName
                || bodyDto.key == BodyFieldTypes.TOPICS.typeName
                || bodyDto.key == BodyFieldTypes.STATIONS.typeName
                || bodyDto.key == BodyFieldTypes.RELATED.typeName
            ) {
                val children = bodyDto.children
                if (!children.isNullOrEmpty()) {
                    if (
                        children[0].type == BodyFieldTypes.LINK.typeName
                        && children[0].item.isNullOrEmpty()
                    ) {
                        return Pair(ContentType.CategoryGrid, false)
                    } else
                        if (children[0].type == BodyFieldTypes.LINK.typeName) { // Get first element from inner list
                            return Pair(ContentType.CategoryList, true)
                        } else if (children[0].type == BodyFieldTypes.AUDIO.typeName
                            && (children[0].item == BodyFieldTypes.TOPIC.typeName
                                    || children[0].item == BodyFieldTypes.SHOW.typeName
                                    || children[0].item == BodyFieldTypes.STATION.typeName)
                        ) {
                            return Pair(ContentType.AudioList, true)
                        } else {
                            return Pair(ContentType.CategoryGrid, true)
                        }
                }
            }
        } else {
            val itemDto = json.decodeFromJsonElement<ItemDto>(rootItem)
            if (
                itemDto.type == BodyFieldTypes.TEXT.typeName
            ) {
                return Pair(ContentType.Empty, false)
            } else if (
                itemDto.type == BodyFieldTypes.AUDIO.typeName
            ) {
                return Pair(ContentType.AudioList, false)
            } else if (
                itemDto.type == BodyFieldTypes.LINK.typeName
                && itemDto.item.isNullOrEmpty()
            ) {
                return Pair(ContentType.CategoryGrid, false)
            } else if (
                itemDto.type == BodyFieldTypes.LINK.typeName
                && (itemDto.item == BodyFieldTypes.SHOW.typeName
                        || itemDto.item == BodyFieldTypes.STATION.typeName
                        || itemDto.item == BodyFieldTypes.LOCAL.typeName)
            ) {
                return Pair(ContentType.CategoryList, false)
            }
        }

        return Pair(ContentType.Empty, false)
    }
}