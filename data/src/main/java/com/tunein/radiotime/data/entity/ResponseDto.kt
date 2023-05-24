package com.tunein.radiotime.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * [ResponseDto] holds a list of [JsonElement].
 * Each element can be either [ItemDto] or [BodyDto] with specific fields.
 */
@Serializable
data class ResponseDto(
    @SerialName("body")
    val body: List<JsonElement>?,
)