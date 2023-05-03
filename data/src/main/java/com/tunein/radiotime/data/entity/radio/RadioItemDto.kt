package com.tunein.radiotime.data.entity.radio

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RadioItemDto(
    @SerialName("URL")
    val url: String?,
    val text: String?,
    val subtext: String?,
    val image: String?,
    val type: String?
)