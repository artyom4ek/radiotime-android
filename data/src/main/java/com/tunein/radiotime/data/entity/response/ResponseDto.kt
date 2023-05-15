package com.tunein.radiotime.data.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class ResponseDto(
    @SerialName("body")
    val body: List<JsonElement>?,
)