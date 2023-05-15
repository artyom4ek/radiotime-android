package com.tunein.radiotime.data.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class BodyDto(
    val text: String?,
    val key: String?,
    val children: List<ItemDto>?,
)