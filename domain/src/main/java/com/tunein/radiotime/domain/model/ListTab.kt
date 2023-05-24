package com.tunein.radiotime.domain.model

/**
 * [ListTab] describes sections of the List tab screen.
 */
data class ListTab(
    val title: String,
    val items: List<ListItem> = emptyList(),
) : BaseTab(baseTitle = title)