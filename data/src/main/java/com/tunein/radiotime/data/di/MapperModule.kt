package com.tunein.radiotime.data.di

import kotlinx.serialization.json.JsonElement

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.ItemDto
import com.tunein.radiotime.data.entity.ResponseDto
import com.tunein.radiotime.data.mapper.*
import com.tunein.radiotime.domain.model.AudioTab
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.GridItem
import com.tunein.radiotime.domain.model.ListItem
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.model.GridTab
import com.tunein.radiotime.domain.model.ListTab

/**
 * [MapperModule] holds Mappers for Data layer.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindsInitialDataMapper(
        mapper: InitialDataDomainMapper
    ): Mapper<InitialData, ResponseDto>

    @Binds
    abstract fun bindsPodcastsMapper(
        mapper: PodcastsDomainMapper
    ): Mapper<GridTab, JsonElement>

    @Binds
    abstract fun bindsAudioItemMapper(
        mapper: AudioItemDomainMapper
    ): Mapper<AudioItem?, ItemDto>

    @Binds
    abstract fun bindsGridItemMapper(
        mapper: GridItemDomainMapper
    ): Mapper<GridItem?, ItemDto>

    @Binds
    abstract fun bindsListItemMapper(
        mapper: ListItemDomainMapper
    ): Mapper<ListItem?, ItemDto>

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

    @Binds
    abstract fun bindsRawDataMapper(
        mapper: RawDataMapperImpl
    ): RawDataMapper

    @Binds
    abstract fun bindsAudioDataMapper(
        mapper: AudioDataDomainMapper
    ): Mapper<String, ResponseDto>
}