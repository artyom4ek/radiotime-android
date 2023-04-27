package com.tunein.radiotime.podcasts

import com.tunein.radiotime.R
import com.tunein.radiotime.podcasts.model.CategoryItem
import com.tunein.radiotime.podcasts.tabs.PodcastTab
import com.tunein.radiotime.podcasts.tabs.PodcastTabScreen

fun providePodcastTabs() = listOf(
    PodcastTab(
        title = "Music",
        icon = R.drawable.ic_music,
        screen = { PodcastTabScreen(provideMusicCategories()) }
    ),
    PodcastTab(
        title = "Talk",
        icon = R.drawable.ic_talk,
        screen = { PodcastTabScreen(provideTalkCategories()) }
    ),
    PodcastTab(
        title = "Sports",
        icon = R.drawable.ic_sport,
        screen = { PodcastTabScreen(provideSportsCategories()) }
    )
)

fun provideMusicCategories() = listOf(
    CategoryItem(0, "World Music", 10),
    CategoryItem(1, "Top 40 & Pop Music", 1),
    CategoryItem(2, "Soul & R&B", 102),
    CategoryItem(3, "Rock Music", 50),
    CategoryItem(4, "Religious Music", 10),
    CategoryItem(5, "Reggae & Dancehall", 76),
    CategoryItem(6, "Latin Music", 13),
    CategoryItem(7, "Jazz", 87),
    CategoryItem(8, "Indie Music", 99),
    CategoryItem(9, "Holiday Music", 23),
    CategoryItem(10, "Hip Hop", 49),
    CategoryItem(11, "Folk", 52),
    CategoryItem(12, "Easy Listening", 145),
    CategoryItem(13, "Decades Music", 11),
    CategoryItem(14, "Dance & Electronic", 77),
)

fun provideTalkCategories() = listOf(
    CategoryItem(0, "This Week's Top 25 Podcasts", 4),
    CategoryItem(1, "Most Popular News Stations", 14),
    CategoryItem(2, "Talk Show Replays", 52),
    CategoryItem(3, "The Best of CBC", 31),
    CategoryItem(4, "De Deportes", 9),
    CategoryItem(5, "Top Public Radio Picks", 68),
    CategoryItem(6, "British Podcast Awards - Nominations", 45),
    CategoryItem(7, "De Noticias", 35),
    CategoryItem(8, "Catholic Talk", 85),
    CategoryItem(9, "Editors' Choice - Talk", 93),
    CategoryItem(10, "Radio-Canada", 101),
    CategoryItem(11, "Entrevista Radiofónico", 48),
    CategoryItem(12, "Top 20 de la semana", 32),
    CategoryItem(13, "Mindfulness", 62),
    CategoryItem(14, "Sci-Fi", 73),
)

fun provideSportsCategories() = listOf(
    CategoryItem(0, "Top Rádios com Futebol Ao Vivo", 74),
    CategoryItem(1, "Tennis", 18),
    CategoryItem(2, "More Sports and Teams", 22),
    CategoryItem(3, "Canadian Hockey", 46),
    CategoryItem(4, "Top Sports Talk Shows", 67),
    CategoryItem(5, "Fantasy Sports", 91),
    CategoryItem(6, "Top Sports Podcasts", 28),
    CategoryItem(7, "Deportes", 43),
    CategoryItem(8, "College Football", 75),
    CategoryItem(9, "Copa America 100", 56),
    CategoryItem(10, "Euro 2016", 87),
    CategoryItem(11, "World Cup", 23),
    CategoryItem(12, "Men's College Basketball", 89),
    CategoryItem(13, "Soccer", 44),
    CategoryItem(14, "Sports Talk & News", 71),
)