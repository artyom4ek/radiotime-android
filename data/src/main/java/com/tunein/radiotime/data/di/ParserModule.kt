package com.tunein.radiotime.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import com.tunein.radiotime.data.parser.Parser

@Module
@InstallIn(SingletonComponent::class)
object ParserModule {

    @Provides
    fun provideParser(): Parser = Parser() // TODO: add interface
}
