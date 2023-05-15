package com.tunein.radiotime.data.entity.main

import kotlinx.serialization.Serializable

@Serializable
data class InitialDataResponseDto(
    val body: List<InitialDataItemDto>?
)
