package com.tunein.radiotime.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * [ItemDto] holds data from several similar models.
 */
@Serializable
data class ItemDto(
    @SerialName("URL")
    val url: String?,
    @SerialName("current_track")
    val currentTrack: String?,
    @SerialName("guide_id")
    val guideId: String?,
    val image: String?,
    val item: String?,
    val subtext: String?,
    val text: String?,
    val type: String?,
    val playing: String?,
    val key: String?
)