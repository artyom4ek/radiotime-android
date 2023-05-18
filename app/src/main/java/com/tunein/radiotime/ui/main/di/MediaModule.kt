package com.tunein.radiotime.ui.main.di

import javax.inject.Singleton

import android.content.Context
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import com.tunein.radiotime.ui.main.media.ExoPlayerPlaybackManager
import com.tunein.radiotime.ui.main.media.PlaybackManager

@UnstableApi
@Module
@InstallIn(SingletonComponent::class)
object MediaModule {

    @Provides
    @Singleton
    fun provideExoPlayer(@ApplicationContext context: Context): ExoPlayer =
        ExoPlayer.Builder(context).build()

    @Provides
    @Singleton
    fun provideExoPlayerPlaybackManager(player: ExoPlayer): PlaybackManager =
        ExoPlayerPlaybackManager(player)
}