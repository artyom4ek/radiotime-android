package com.tunein.radiotime.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class BodyDto(
    val text: String?,
    val key: String?,
    val type: String?,
    val guide_id: String?,
    val children: List<ItemDto>?,
)