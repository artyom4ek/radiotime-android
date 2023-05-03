package com.tunein.radiotime.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseItemDto(
    @SerialName("URL")
    val url: String,
    val key: String,
    val text: String,
    val type: String
)
