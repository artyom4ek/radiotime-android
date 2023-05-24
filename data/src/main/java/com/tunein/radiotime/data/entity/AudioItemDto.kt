package com.tunein.radiotime.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * [AudioItemDto] is used to serialize data for playback.
 */
@Serializable
data class AudioItemDto(
    @SerialName("url")
    val url: String?
)