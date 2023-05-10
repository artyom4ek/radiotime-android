package com.tunein.radiotime.data.entity.categoryDetails

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChildrenDto(
    @SerialName("URL")
    val url: String,
    @SerialName("bitrate")
    val bitrate: String?,
    @SerialName("current_track")
    val currentTrack: String?,
    @SerialName("image")
    val image: String?,
    @SerialName("item")
    val item: String?,
    @SerialName("key")
    val key: String?,
    @SerialName("playing")
    val playing: String?,
    @SerialName("playing_image")
    val playingImage: String?,
    @SerialName("subtext")
    val subtext: String?,
    @SerialName("text")
    val text: String?,
    @SerialName("type")
    val type: String?
)