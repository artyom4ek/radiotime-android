package com.tunein.radiotime.data.entity

import kotlinx.serialization.Serializable

/**
 * [BodyDto] holds data with a child list of items.
 */
@Serializable
data class BodyDto(
    val text: String?,
    val type: String?,
    val children: List<ItemDto>?,
)