package com.tunein.radiotime.data.mapper

import kotlin.random.Random

import javax.inject.Inject

import com.tunein.radiotime.common.R
import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.common.network.ResponseKeys
import com.tunein.radiotime.data.entity.main.InitialDataResponseDto
import com.tunein.radiotime.domain.model.CategoryItem
import com.tunein.radiotime.domain.model.HomeTab
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.model.PodcastsTab
import com.tunein.radiotime.domain.model.RadioTab

/**
 * Mapper class for convert [InitialDataResponseDto] to [InitialData] and vice versa
 */
class InitialDataDomainMapper @Inject constructor() : Mapper<InitialDataResponseDto, InitialData> {

    override fun from(i: InitialDataResponseDto?): InitialData {

        // Prepare initial data for Home tab
        val homeDiscover = mutableListOf<CategoryItem>()
        i?.body?.forEach {
            when (it.key) {
                ResponseKeys.MUSIC.key -> homeDiscover.add(
                    CategoryItem(
                        title = it.text,
                        url = it.url,
                        icon = R.drawable.ic_music
                    )
                )

                ResponseKeys.TALK.key -> homeDiscover.add(
                    CategoryItem(
                        title = it.text,
                        url = it.url,
                        count = Random.nextInt(10, 51), // TODO: should be implemented later
                        icon = R.drawable.ic_talk
                    )
                )

                ResponseKeys.SPORTS.key -> homeDiscover.add(
                    CategoryItem(
                        title = it.text,
                        url = it.url,
                        count = Random.nextInt(10, 51), // TODO: should be implemented later
                        icon = R.drawable.ic_sport
                    )
                )
            }
        }

        val homeFilters = mutableListOf<CategoryItem>()
        i?.body?.forEach {
            when (it.key) {
                ResponseKeys.LOCATION.key -> homeFilters.add(
                    CategoryItem(
                        title = it.text,
                        url = it.url,
                        icon = R.drawable.ic_location
                    )
                )

                ResponseKeys.LANGUAGE.key -> homeFilters.add(
                    CategoryItem(
                        title = it.text,
                        url = it.url,
                        icon = R.drawable.ic_language
                    )
                )
            }
        }

        val homeTab = HomeTab(
            discover = homeDiscover,
            filter = homeFilters
        )

        // Prepare initial data for Radio tab
        val radio = i?.body?.find { it.key == ResponseKeys.LOCAL.key }
        val radioTitle = radio?.text
        val radioUrl = radio?.url
        val radioTab = RadioTab(radioTitle, radioUrl)

        // Prepare initial data for Podcast tab
        val podcast = i?.body?.find { it.key == ResponseKeys.PODCAST.key }
        val podcastTitle = podcast?.text
        val podcastUrl = podcast?.url
        val podcastsTab = PodcastsTab(podcastTitle, podcastUrl)

        return InitialData(
            homeTab = homeTab,
            radioTab = radioTab,
            podcastsTab = podcastsTab
        )
    }

    override fun to(o: InitialData?): InitialDataResponseDto {
        return InitialDataResponseDto(emptyList())
    }
}