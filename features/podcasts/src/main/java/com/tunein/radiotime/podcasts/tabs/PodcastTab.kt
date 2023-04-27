package com.tunein.radiotime.podcasts.tabs

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable

class PodcastTab(
    val title: String,
    @DrawableRes val icon: Int,
    val screen: @Composable () -> Unit
)
