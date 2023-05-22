package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.Json

import com.tunein.radiotime.common.R
import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.common.network.ResponseKeys
import com.tunein.radiotime.data.entity.ItemDto
import com.tunein.radiotime.data.entity.ResponseDto
import com.tunein.radiotime.domain.model.GridItem
import com.tunein.radiotime.domain.model.HomeTab
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.model.PodcastsTab
import com.tunein.radiotime.domain.model.RadioTab

/**
 * Mapper class for convert [ResponseDto] to [InitialData]
 */
class InitialDataDomainMapper @Inject constructor(
    private val json: Json
) : Mapper<InitialData, ResponseDto> {

    override fun to(o: ResponseDto?): InitialData {
        if (o == null) throw Exception("Invalid response")

        val items = o.body?.map { json.decodeFromJsonElement<ItemDto>(it) } ?: emptyList()

        // Prepare initial data for Home tab
        val homeDiscover = mutableListOf<GridItem>()
        items.forEach {
            when (it.key) {
                ResponseKeys.MUSIC.key -> homeDiscover.add(
                    GridItem(
                        title = it.text ?: "",
                        url = it.url ?: "",
                        icon = R.drawable.ic_music
                    )
                )

                ResponseKeys.TALK.key -> homeDiscover.add(
                    GridItem(
                        title = it.text ?: "",
                        url = it.url ?: "",
                        icon = R.drawable.ic_talk
                    )
                )

                ResponseKeys.SPORTS.key -> homeDiscover.add(
                    GridItem(
                        title = it.text ?: "",
                        url = it.url ?: "",
                        icon = R.drawable.ic_sport
                    )
                )
            }
        }

        val homeFilters = mutableListOf<GridItem>()
        items.forEach {
            when (it.key) {
                ResponseKeys.LOCATION.key -> homeFilters.add(
                    GridItem(
                        title = it.text ?: "",
                        url = it.url ?: "",
                        icon = R.drawable.ic_location
                    )
                )

                ResponseKeys.LANGUAGE.key -> homeFilters.add(
                    GridItem(
                        title = it.text ?: "",
                        url = it.url ?: "",
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
        val radio = items.find { it.key == ResponseKeys.LOCAL.key }
        val radioTitle = radio?.text
        val radioUrl = radio?.url
        val radioTab = RadioTab(radioTitle, radioUrl)

        // Prepare initial data for Podcasts tab
        val podcasts = items.find { it.key == ResponseKeys.PODCAST.key }
        val podcastTitle = podcasts?.text
        val podcastsUrl = podcasts?.url
        val podcastsTab = PodcastsTab(podcastTitle, podcastsUrl)

        return InitialData(
            homeTab = homeTab,
            radioTab = radioTab,
            podcastsTab = podcastsTab
        )
    }
}