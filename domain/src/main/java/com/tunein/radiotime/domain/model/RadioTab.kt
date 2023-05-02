package com.tunein.radiotime.domain.model

/**
 * [RadioTab] describes sections of the Podcast screen
 */
data class RadioTab(
    val title: String?,
    val url: String?,
    val radioStations: List<RadioStation> = emptyList()
)
