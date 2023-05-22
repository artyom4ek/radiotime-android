package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

import com.tunein.radiotime.common.R
import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.common.network.ResponseKeys
import com.tunein.radiotime.data.entity.BodyDto
import com.tunein.radiotime.domain.model.GridItem
import com.tunein.radiotime.domain.model.GridTab

class PodcastsDomainMapper @Inject constructor(
    private val json: Json
) : Mapper<GridTab, JsonElement> {

    override fun to(o: JsonElement?): GridTab {
        if (o == null) throw NullPointerException("JsonElement mustn't be null")

        val body = json.decodeFromJsonElement<BodyDto>(o.jsonObject)
        val icon = when (body.text?.lowercase()) {
            ResponseKeys.MUSIC.key -> R.drawable.ic_music
            ResponseKeys.TALK.key -> R.drawable.ic_talk
            ResponseKeys.SPORTS.key -> R.drawable.ic_sport
            else -> null
        }
        return GridTab(
            title = body.text ?: "",
            icon = icon,
            items = body.children?.map {
                GridItem(
                    title = it.text ?: "",
                    url = it.url ?: "",
                )
            } ?: emptyList()
        )
    }
}