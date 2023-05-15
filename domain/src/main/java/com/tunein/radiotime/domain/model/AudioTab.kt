package com.tunein.radiotime.domain.model

import androidx.annotation.DrawableRes

/**
 * [AudioTab] describes an Audio Tab model
 */
data class AudioTab(
    val title: String,
    val key: String?,
    val items: List<AudioItem> = emptyList(),
    @DrawableRes val icon: Int? = null
) : BaseTab(baseTitle = title, baseKey = key)
