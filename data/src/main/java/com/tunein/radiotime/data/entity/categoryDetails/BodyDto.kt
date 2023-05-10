package com.tunein.radiotime.data.entity.categoryDetails

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BodyDto(
    @SerialName("children")
    val children: List<ChildrenDto>?,
    val key: String?,
    val text: String?
)