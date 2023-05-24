package com.tunein.radiotime.data.parser

import kotlinx.serialization.json.JsonElement

import com.tunein.radiotime.common.utils.ContentType
import com.tunein.radiotime.data.entity.ItemDto

/**
 * [Parser] contains methods for parsing raw data.
 */
interface Parser {

    /**
     * Method checks for the existence of a list of child elements.
     */
    fun checkIfChildrenExists(bodyList: List<JsonElement>?): Boolean

    /**
     * Method determines the element's content type.
     */
    fun itemAnalysis(itemDto: ItemDto): ContentType
}