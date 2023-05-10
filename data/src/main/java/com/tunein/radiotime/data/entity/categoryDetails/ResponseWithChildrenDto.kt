package com.tunein.radiotime.data.entity.categoryDetails

import kotlinx.serialization.Serializable

@Serializable
data class ResponseWithChildrenDto(
    val body: List<BodyDto>,
)