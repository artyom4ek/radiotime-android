package com.tunein.radiotime.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.data.entity.ResponseDto
import com.tunein.radiotime.data.entity.radio.RadioItemDto
import com.tunein.radiotime.data.mapper.InitialDataDomainMapper
import com.tunein.radiotime.data.mapper.RadioStationsDomainMapper
import com.tunein.radiotime.domain.model.InitialData
import com.tunein.radiotime.domain.model.RadioStation

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

    @Binds
    abstract fun bindsRadioStationsMapper(
        mapper: RadioStationsDomainMapper
    ): Mapper<RadioStation, RadioItemDto>
}