package com.tunein.radiotime.data.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class ItemDto(
    val URL: String,
    val current_track: String?,
    val guide_id: String?,
    val image: String?,
    val item: String?,
    val now_playing_id: String?,
    val stream_type: String?,
    val subtext: String?,
    val text: String?,
    val topic_duration: String?,
    val type: String?,
    val genre_id: String?,
    val preset_id: String?,
    val playing: String?,
    val playing_image: String?,
    val key: String?
)