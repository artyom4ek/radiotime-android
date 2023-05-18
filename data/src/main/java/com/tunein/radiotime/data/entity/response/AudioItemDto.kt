package com.tunein.radiotime.data.entity.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AudioItemDto(
    @SerialName("url")
    val url: String?
)