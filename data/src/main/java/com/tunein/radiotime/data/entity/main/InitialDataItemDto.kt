package com.tunein.radiotime.data.entity.main

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InitialDataItemDto(
    @SerialName("URL")
    val url: String,
    val key: String,
    val text: String,
    val type: String
)
