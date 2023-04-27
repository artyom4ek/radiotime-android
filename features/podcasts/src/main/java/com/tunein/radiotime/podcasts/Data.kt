package com.tunein.radiotime.podcasts

import com.tunein.radiotime.R

fun providePodcastTabs() = listOf(
    Tab(
        title = "Music",
        icon = R.drawable.ic_music,
        screen = { TabScreen(content = "Music") }
    ),
    Tab(
        title = "Talk",
        icon = R.drawable.ic_talk,
        screen = { TabScreen(content = "Talk") }
    ),
    Tab(
        title = "Sport",
        icon = R.drawable.ic_sport,
        screen = { TabScreen(content = "Sport") }
    )
)