package com.tunein.radiotime.domain.model

/**
 * [RadioStation] model describes the element of the radio station
 */
data class RadioStation(
    val type: String?,
    val url: String?,
    val title: String,
    val subTitle: String,
    val cover: String?
)
