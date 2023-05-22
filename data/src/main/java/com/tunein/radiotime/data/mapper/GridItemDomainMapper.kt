package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.ItemDto
import com.tunein.radiotime.domain.model.GridItem

class GridItemDomainMapper @Inject constructor() : Mapper<GridItem?, ItemDto> {

    override fun from(i: GridItem?): ItemDto {
        TODO("Not yet implemented")
    }

    override fun to(o: ItemDto?): GridItem? {
        o?.let {
            return GridItem(
                title = it.text ?: "",
                url = it.url ?: ""
            )
        }
        return null
    }
}