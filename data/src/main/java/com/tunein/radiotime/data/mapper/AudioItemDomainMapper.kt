package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.ItemDto
import com.tunein.radiotime.domain.model.AudioItem

/**
 * [AudioItemDomainMapper] responsible for mapping a [ItemDto] to a [AudioItem].
 */
class AudioItemDomainMapper @Inject constructor() : Mapper<AudioItem?, ItemDto> {

    override fun to(o: ItemDto?): AudioItem? {
        o?.let {
            return AudioItem(
                title = it.text ?: "",
                subTitle = it.subtext ?: "",
                url = it.url ?: "",
                track = it.currentTrack ?: o.playing ?: it.subtext,
                cover = it.image
            )
        }
        return null
    }
}