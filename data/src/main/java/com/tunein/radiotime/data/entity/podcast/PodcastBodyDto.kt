package com.tunein.radiotime.data.entity.podcast

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PodcastBodyDto(
    val text: String?,
    @SerialName("children")
    val items: List<PodcastItemDto>?
)