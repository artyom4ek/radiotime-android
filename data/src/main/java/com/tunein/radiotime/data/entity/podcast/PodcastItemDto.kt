package com.tunein.radiotime.data.entity.podcast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PodcastItemDto(
    @SerialName("URL")
    val url: String?,
    val text: String,
    val type: String
)