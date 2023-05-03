package com.tunein.radiotime.data.entity.radio

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RadioBodyDto(
    @SerialName("children")
    val items: List<RadioItemDto>?,
    val element: String?,
    val key: String?,
    val text: String?
)