package com.tunein.radiotime.data.mapper

import kotlin.random.Random

import javax.inject.Inject

import com.tunein.radiotime.common.R
import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.common.network.ResponseKeys
import com.tunein.radiotime.data.entity.podcast.PodcastBodyDto
import com.tunein.radiotime.domain.model.Category
import com.tunein.radiotime.domain.model.CategoryItem

class PodcastsDomainMapper @Inject constructor() : Mapper<Category, PodcastBodyDto> {

    override fun from(i: Category?): PodcastBodyDto {
        return PodcastBodyDto("", emptyList())
    }

    override fun to(o: PodcastBodyDto?): Category {
        val title = o?.text ?: ""
        val icon = when (title.lowercase()) {
            ResponseKeys.MUSIC.key -> R.drawable.ic_music
            ResponseKeys.TALK.key -> R.drawable.ic_talk
            ResponseKeys.SPORTS.key -> R.drawable.ic_sport
            else -> {
                R.drawable.ic_headphones
            }
        }
        return Category(
            title = title,
            icon = icon,
            items = o?.items?.map {
                CategoryItem(
                    title = it.text,
                    url = it.url ?: "",
                    count = Random.nextInt(10, 51) // TODO: should be implemented later
                )
            } ?: emptyList()
        )
    }
}