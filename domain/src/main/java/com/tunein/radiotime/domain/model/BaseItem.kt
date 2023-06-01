package com.tunein.radiotime.domain.model

/**
 * [BaseItem] describes the model of the base item not associated with Tabs.
 */
open class BaseItem(
    val baseTitle: String,
    val baseUrl: String
) : CategoryItems
