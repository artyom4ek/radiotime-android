package com.tunein.radiotime.ui.main.media

import javax.inject.Inject

import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

class ExoPlayerPlaybackManager @Inject constructor(
    private val exoPlayer: ExoPlayer
) : PlaybackManager {

    override fun play(url: String) {
        val mediaItem = MediaItem.fromUri(Uri.parse(url))
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    override fun stop() {
        exoPlayer.stop()
    }
}