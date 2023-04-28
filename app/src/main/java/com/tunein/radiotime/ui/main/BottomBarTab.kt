package com.tunein.radiotime.ui.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

import com.tunein.radiotime.R

sealed class BottomBarTab(
    val route: String,
    @DrawableRes val icon: Int,
    @StringRes val title: Int
) {
    object Home : BottomBarTab("Home", R.drawable.ic_home, R.string.home)
    object Radio : BottomBarTab("radio", R.drawable.ic_radio, R.string.radio)
    object Podcast : BottomBarTab("podcast", R.drawable.ic_podcast, R.string.podcast)
}