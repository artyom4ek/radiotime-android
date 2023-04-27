package com.tunein.radiotime.podcasts

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable

class Tab(
    val title: String,
    @DrawableRes val icon: Int,
    val screen: @Composable () -> Unit
)
