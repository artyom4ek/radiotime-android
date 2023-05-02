package com.tunein.radiotime.domain.model

/**
 * Store initial data in [InitialData] for display on Main screen
 */
data class InitialData(
    val home: HomeTab,
    val radio: RadioTab,
    val podcast: PodcastTab
)
