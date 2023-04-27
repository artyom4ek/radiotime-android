package com.tunein.radiotime.podcasts

import androidx.compose.runtime.Composable

@Composable
fun PodcastsScreen() {
    PodcastsSection(podcastTabs = providePodcastTabs())
}