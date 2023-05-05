package com.tunein.radiotime.home

import com.tunein.radiotime.common.R
import com.tunein.radiotime.domain.model.CategoryItem

fun provideDiscoverCategories() = listOf(
    CategoryItem("Music", "", R.drawable.ic_music),
    CategoryItem("Talk", "", R.drawable.ic_talk),
    CategoryItem("Sports", "", R.drawable.ic_sport)
)

fun provideFilterItems() = listOf(
    CategoryItem("By Locations", "url1", R.drawable.ic_location),
    CategoryItem("By Language", "url2", R.drawable.ic_language)
)