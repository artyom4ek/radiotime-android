package com.tunein.radiotime.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class InitialDataResponseDto(
    val body: List<InitialDataItemDto>?
)
