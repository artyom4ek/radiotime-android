package com.tunein.radiotime.podcasts

import androidx.compose.runtime.Composable
import com.tunein.radiotime.domain.model.PodcastsTab

@Composable
fun PodcastsScreen(podcastsTab: PodcastsTab?) {
    PodcastsSection(
        podcastTabs = podcastsTab?.podcastCategories?.toList() ?: emptyList(),
        onClick = {})
}