package com.tunein.radiotime.domain.model

/**
 * [RadioTab] describes sections of the Radio tab screen
 */
data class RadioTab(
    val title: String?,
    val url: String?,
    val stations: MutableList<AudioItem> = mutableListOf()
)