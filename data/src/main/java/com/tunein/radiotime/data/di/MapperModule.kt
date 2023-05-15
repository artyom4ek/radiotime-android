package com.tunein.radiotime.data.di

import kotlinx.serialization.json.JsonElement

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.main.InitialDataResponseDto
import com.tunein.radiotime.data.entity.podcast.PodcastBodyDto
import com.tunein.radiotime.data.entity.radio.RadioItemDto
import com.tunein.radiotime.data.mapper.AudioTabDomainMapper
import com.tunein.radiotime.data.mapper.AudioItemDomainMapper
import com.tunein.radiotime.data.mapper.GridItemDomainMapper
import com.tunein.radiotime.data.mapper.ListItemDomainMapper
import com.tunein.radiotime.data.mapper.InitialDataDomainMapper
import com.tunein.radiotime.data.mapper.PodcastsDomainMapper
import com.tunein.radiotime.data.mapper.RadioStationsDomainMapper
import com.tunein.radiotime.data.mapper.GridTabDomainMapper
import com.tunein.radiotime.data.mapper.ListTabDomainMapper
import com.tunein.radiotime.domain.model.AudioTab
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.Category
import com.tunein.radiotime.domain.model.GridItem
import com.tunein.radiotime.domain.model.ListItem
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.model.RadioStation
import com.tunein.radiotime.domain.model.GridTab
import com.tunein.radiotime.domain.model.ListTab

/**
 * Module that holds Mappers
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindsInitialDataMapper(
        mapper: InitialDataDomainMapper
    ): Mapper<InitialDataResponseDto, InitialData>

    @Binds
    abstract fun bindsRadioStationsMapper(
        mapper: RadioStationsDomainMapper
    ): Mapper<RadioStation, RadioItemDto>

    @Binds
    abstract fun bindsPodcastsMapper(
        mapper: PodcastsDomainMapper
    ): Mapper<Category, PodcastBodyDto>

    @Binds
    abstract fun bindsAudioItemMapper(
        mapper: AudioItemDomainMapper
    ): Mapper<AudioItem, JsonElement>

    @Binds
    abstract fun bindsGridItemMapper(
        mapper: GridItemDomainMapper
    ): Mapper<GridItem, JsonElement>

    @Binds
    abstract fun bindsListItemMapper(
        mapper: ListItemDomainMapper
    ): Mapper<ListItem, JsonElement>

    @Binds
    abstract fun bindsAudioTabMapper(
        mapper: AudioTabDomainMapper
    ): Mapper<AudioTab, JsonElement>

    @Binds
    abstract fun bindsGridTabMapper(
        mapper: GridTabDomainMapper
    ): Mapper<GridTab, JsonElement>

    @Binds
    abstract fun bindsListTabMapper(
        mapper: ListTabDomainMapper
    ): Mapper<ListTab, JsonElement>
}