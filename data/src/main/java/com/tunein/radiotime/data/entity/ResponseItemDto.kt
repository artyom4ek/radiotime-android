package com.tunein.radiotime.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class ResponseItemDto(
    val URL: String,
    val key: String,
    val text: String,
    val type: String
)
