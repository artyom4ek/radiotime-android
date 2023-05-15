package com.tunein.radiotime.data.parser

import com.tunein.radiotime.common.utils.ContentType
import kotlinx.serialization.json.JsonElement

interface Parser {

    fun responseAnalysis(body: List<JsonElement>?): Pair<ContentType, Boolean>
}