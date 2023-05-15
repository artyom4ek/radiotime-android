package com.tunein.radiotime.domain.model

/**
 * [AudioItem] describes an audio item model
 */
data class AudioItem(
    val title: String,
    val subTitle: String? = null,
    val url: String,
    val track: String? = null,
    val duration: String? = null,
    val cover: String? = null,
) : CategoryItems
