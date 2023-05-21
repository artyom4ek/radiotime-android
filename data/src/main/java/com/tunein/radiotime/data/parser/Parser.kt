package com.tunein.radiotime.data.parser

import kotlinx.serialization.json.JsonElement

import com.tunein.radiotime.common.utils.ContentType
import com.tunein.radiotime.data.entity.ItemDto

interface Parser {

    fun checkIfChildrenExists(bodyList: List<JsonElement>?): Boolean

    fun itemAnalysis(itemDto: ItemDto): ContentType
}