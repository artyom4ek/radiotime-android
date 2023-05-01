package com.tunein.radiotime.data.di

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.tunein.radiotime.data.repository.MainRepositoryImpl
import com.tunein.radiotime.domain.repository.MainRepository

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideMainRepository(): MainRepository = MainRepositoryImpl()
}