package com.tunein.radiotime.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.tunein.radiotime.data.parser.Parser
import com.tunein.radiotime.data.parser.ParserImpl
import com.tunein.radiotime.domain.repository.MainRepository

/**
 * [ParserModule] holds parser methods.
 */
@Module
@InstallIn(SingletonComponent::class)
object ParserModule {

    /**
     * Provides [Parser] instance
     */
    @Provides
    fun provideParser(): Parser = ParserImpl()
}
