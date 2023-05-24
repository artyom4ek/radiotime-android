package com.tunein.radiotime.domain.model

import androidx.annotation.DrawableRes

/**
 * [AudioTab] describes sections of the Audio tab screen.
 */
data class AudioTab(
    val title: String,
    val items: List<AudioItem> = emptyList(),
    @DrawableRes val icon: Int? = null
) : BaseTab(baseTitle = title)
