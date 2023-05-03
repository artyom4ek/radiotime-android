package com.tunein.radiotime.data.di

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.ResponseDto
import com.tunein.radiotime.data.entity.radio.RadioBodyDto
import com.tunein.radiotime.data.entity.radio.RadioItemDto
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.data.repository.MainRepositoryImpl
import com.tunein.radiotime.data.repository.RadioRepositoryImpl
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.model.RadioStation
import com.tunein.radiotime.domain.repository.MainRepository
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
        initialDataMapper: Mapper<ResponseDto, InitialData>
    ): MainRepository =
        MainRepositoryImpl(remoteDataSource, initialDataMapper)

    @Provides
    @Singleton
    fun provideRadioRepository(
        retrofit: Retrofit,
        radioStationsMapper: Mapper<RadioStation, RadioItemDto>
    ): RadioRepository =
        RadioRepositoryImpl(retrofit, radioStationsMapper)
}