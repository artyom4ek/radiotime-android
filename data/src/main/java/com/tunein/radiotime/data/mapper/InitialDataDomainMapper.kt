package com.tunein.radiotime.data.mapper

import javax.inject.Inject

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.common.network.ResponseKeys
import com.tunein.radiotime.data.entity.ResponseDto
import com.tunein.radiotime.domain.model.Category
import com.tunein.radiotime.domain.model.HomeTab
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.model.PodcastTab
import com.tunein.radiotime.domain.model.RadioTab

/**
 * Mapper class for convert [ResponseDto] to [InitialData] and vice versa
 */
class InitialDataDomainMapper @Inject constructor() : Mapper<ResponseDto, InitialData> {

    override fun from(i: ResponseDto?): InitialData {

        // Prepare initial data for Home tab
        val homeDiscover =
            i?.body?.filter {
                it.key == ResponseKeys.MUSIC.key
                        || it.key == ResponseKeys.TALK.key
                        || it.key == ResponseKeys.SPORTS.key
            }?.map { Category(text = it.text, url = it.url) } ?: listOf()

        val homeFilter =
            i?.body?.filter {
                it.key == ResponseKeys.LOCATION.key || it.key == ResponseKeys.LANGUAGE.key
            }?.map { Category(text = it.text, url = it.url) } ?: listOf()

        val homeTab = HomeTab(
            discover = homeDiscover,
            filter = homeFilter
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
        val podcastTab = PodcastTab(podcastTitle, podcastUrl)

        return InitialData(
            homeTab = homeTab,
            radioTab = radioTab,
            podcastTab = podcastTab
        )
    }

    override fun to(o: InitialData?): ResponseDto {
        return ResponseDto(emptyList())
    }
}