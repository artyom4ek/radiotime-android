package com.tunein.radiotime.domain.model

/**
 * [RadioStation] model describes the element of the radio station
 */
data class RadioStation(
    val type: String?,
    val url: String?,
    val text: String?,
    val subtext: String?,
    val image: String?
)
