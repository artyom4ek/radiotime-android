package com.tunein.radiotime.data.di

import javax.inject.Singleton

import kotlinx.serialization.json.JsonElement

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.main.InitialDataResponseDto
import com.tunein.radiotime.data.entity.podcast.PodcastBodyDto
import com.tunein.radiotime.data.entity.radio.RadioItemDto
import com.tunein.radiotime.data.parser.Parser
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.data.repository.MainRepositoryImpl
import com.tunein.radiotime.data.repository.PodcastsRepositoryImpl
import com.tunein.radiotime.data.repository.RadioRepositoryImpl
import com.tunein.radiotime.domain.model.AudioTab
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.Category
import com.tunein.radiotime.domain.model.GridItem
import com.tunein.radiotime.domain.model.ListItem
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.model.RadioStation
import com.tunein.radiotime.domain.model.GridTab
import com.tunein.radiotime.domain.model.ListTab
import com.tunein.radiotime.domain.repository.MainRepository
import com.tunein.radiotime.domain.repository.PodcastsRepository
import com.tunein.radiotime.domain.repository.RadioRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     * Provides [MainRepository] instance
     */
    @Provides
    @Singleton
    fun provideMainRepository(
        parser: Parser,
        remoteDataSource: RemoteDataSource,
        initialDataMapper: Mapper<InitialDataResponseDto, InitialData>,
        gridTabDomainMapper: Mapper<GridTab, JsonElement>,
        gridItemDomainMapper: Mapper<GridItem, JsonElement>,
        listTabDomainMapper: Mapper<ListTab, JsonElement>,
        listItemDomainMapper: Mapper<ListItem, JsonElement>,
        audioTabDomainMapper: Mapper<AudioTab, JsonElement>,
        audioItemMapper: Mapper<AudioItem, JsonElement>
    ): MainRepository =
        MainRepositoryImpl(
            parser,
            remoteDataSource,
            initialDataMapper,
            gridTabDomainMapper,
            gridItemDomainMapper,
            listTabDomainMapper,
            listItemDomainMapper,
            audioTabDomainMapper,
            audioItemMapper,
        )

    /**
     * Provides [RadioRepository] instance
     */
    @Provides
    @Singleton
    fun provideRadioRepository(
        retrofit: Retrofit,
        radioStationsMapper: Mapper<RadioStation, RadioItemDto>
    ): RadioRepository =
        RadioRepositoryImpl(retrofit, radioStationsMapper)

    /**
     * Provides [PodcastsRepository] instance
     */
    @Provides
    @Singleton
    fun providePodcastsRepository(
        retrofit: Retrofit,
        podcastsDomainMapper: Mapper<Category, PodcastBodyDto>
    ): PodcastsRepository =
        PodcastsRepositoryImpl(retrofit, podcastsDomainMapper)
}