package com.tunein.radiotime.data.entity.podcast

import kotlinx.serialization.Serializable

@Serializable
data class PodcastsResponseDto(
    val body: List<PodcastBodyDto>,
)