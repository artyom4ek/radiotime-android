package com.tunein.radiotime.data.entity.radio

import kotlinx.serialization.Serializable

@Serializable
data class RadioResponseDto(
    val body: List<RadioBodyDto>?,
)