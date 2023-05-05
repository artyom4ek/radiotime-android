package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.podcast.PodcastBodyDto
import com.tunein.radiotime.domain.model.Category
import com.tunein.radiotime.domain.model.CategoryItem

class PodcastsDomainMapper @Inject constructor() : Mapper<Category, PodcastBodyDto> {

    override fun from(i: Category?): PodcastBodyDto {
        return PodcastBodyDto("", emptyList())
    }

    override fun to(o: PodcastBodyDto?): Category {
        return Category(
            title = o?.text ?: "",
            items = o?.items?.map {
                CategoryItem(
                    title = it.text,
                    url = it.url ?: ""
                )
            } ?: emptyList()
        )
    }
}