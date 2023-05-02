package com.tunein.radiotime.data.di

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.ResponseDto
import com.tunein.radiotime.data.remote.RemoteDataSource
import com.tunein.radiotime.data.repository.MainRepositoryImpl
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.repository.MainRepository

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
}