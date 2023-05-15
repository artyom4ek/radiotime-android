package com.tunein.radiotime.domain.model

/**
 * [ListTab] describes a List Tab model
 */
data class ListTab(
    val title: String,
    val key: String?,
    val items: List<ListItem> = emptyList(),
) : BaseTab(baseTitle = title, baseKey = key)