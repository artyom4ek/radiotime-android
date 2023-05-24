package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.AudioItemDto
import com.tunein.radiotime.data.entity.ResponseDto

/**
 * [AudioDataDomainMapper] responsible for mapping a [ResponseDto] to a [String] representing an audio URL.
 */
class AudioDataDomainMapper @Inject constructor(
    private val json: Json,
) : Mapper<String, ResponseDto> {

    override fun to(o: ResponseDto?): String {
        if (o == null) throw Exception("Invalid response")

        o.body?.let {
            if (it.isNotEmpty()) {
                val itemDto = json.decodeFromJsonElement<AudioItemDto>(it[0])
                return itemDto.url ?: throw Exception("Empty audio url")
            }
        }

        throw Exception("Invalid audio url")
    }
}