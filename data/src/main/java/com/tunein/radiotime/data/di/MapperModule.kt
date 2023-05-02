package com.tunein.radiotime.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.ResponseDto
import com.tunein.radiotime.data.mapper.InitialDataDomainMapper
import com.tunein.radiotime.domain.model.InitialData

/**
 * Module that holds Mappers
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindsInitialDataMapper(
        mapper: InitialDataDomainMapper
    ): Mapper<ResponseDto, InitialData>
}