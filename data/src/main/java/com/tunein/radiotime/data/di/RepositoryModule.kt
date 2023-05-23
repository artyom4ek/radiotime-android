package com.tunein.radiotime.data.di

import javax.inject.Singleton

import kotlinx.serialization.json.JsonElement

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.ResponseDto
import com.tunein.radiotime.data.mapper.PodcastsDomainMapper
import com.tunein.radiotime.data.mapper.RawDataMapper
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.data.repository.MainRepositoryImpl
import com.tunein.radiotime.data.repository.MediaRepositoryImpl
import com.tunein.radiotime.data.repository.PodcastsRepositoryImpl
import com.tunein.radiotime.data.repository.RadioRepositoryImpl
import com.tunein.radiotime.domain.model.AudioTab
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.repository.MainRepository
import com.tunein.radiotime.domain.repository.MediaRepository
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
        remoteDataSource: RemoteDataSource,
        initialDataMapper: Mapper<InitialData, ResponseDto>,
        rawDataMapper: RawDataMapper
    ): MainRepository =
        MainRepositoryImpl(
            remoteDataSource,
            initialDataMapper,
            rawDataMapper
        )

    /**
     * Provides [RadioRepository] instance
     */
    @Provides
    @Singleton
    fun provideRadioRepository(
        remoteDataSource: RemoteDataSource,
        audioTabMapper: Mapper<AudioTab, JsonElement>,
    ): RadioRepository =
        RadioRepositoryImpl(remoteDataSource, audioTabMapper)

    /**
     * Provides [PodcastsRepository] instance
     */
    @Provides
    @Singleton
    fun providePodcastsRepository(
        remoteDataSource: RemoteDataSource,
        podcastsDomainMapper: PodcastsDomainMapper
    ): PodcastsRepository =
        PodcastsRepositoryImpl(remoteDataSource, podcastsDomainMapper)

    /**
     * Provides [MediaRepository] instance
     */
    @Provides
    @Singleton
    fun provideMediaRepository(
        remoteDataSource: RemoteDataSource,
        audioDataDomainMapper: Mapper<String, ResponseDto>
    ): MediaRepository =
        MediaRepositoryImpl(remoteDataSource, audioDataDomainMapper)
}