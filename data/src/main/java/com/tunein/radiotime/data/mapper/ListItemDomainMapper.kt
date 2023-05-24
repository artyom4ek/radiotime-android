package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.ItemDto
import com.tunein.radiotime.domain.model.ListItem

/**
 * [ListItemDomainMapper] responsible for mapping a [ItemDto] to a [ListItem].
 */
class ListItemDomainMapper @Inject constructor() : Mapper<ListItem?, ItemDto> {

    override fun to(o: ItemDto?): ListItem? {
        o?.let {
            return ListItem(
                title = it.text ?: "",
                subTitle = it.subtext ?: "",
                currentTrack = it.currentTrack,
                url = it.url ?: "",
                cover = it.image,
            )
        }
        return null
    }
}