package com.tunein.radiotime.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class ResponseDto(
    val body: List<ResponseItemDto>?
)
