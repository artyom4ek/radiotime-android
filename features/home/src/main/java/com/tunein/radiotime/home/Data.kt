package com.tunein.radiotime.home

import com.tunein.radiotime.common.R
import com.tunein.radiotime.home.model.FilterItem

fun provideDiscoverCategories() = listOf(
    Category("Music", R.drawable.ic_music),
    Category("Talk", R.drawable.ic_talk),
    Category("Sports", R.drawable.ic_sport)
)

fun provideFilterItems() = listOf(
    FilterItem(R.drawable.ic_location, "By Locations", "url1"),
    FilterItem(R.drawable.ic_language, "By Language", "url2"),
)