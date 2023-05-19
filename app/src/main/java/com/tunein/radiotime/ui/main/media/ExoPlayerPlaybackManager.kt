package com.tunein.radiotime.ui.main.media

import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer

import javax.inject.Inject

class ExoPlayerPlaybackManager @Inject constructor(
    private val player: ExoPlayer
) : PlaybackManager {

    override fun play(url: String) {
        val mediaItem = MediaItem.fromUri(Uri.parse(url))
        player.setMediaItem(mediaItem)
        player.prepare()
        player.playWhenReady = true
    }

    override fun play() {
        player.play()
    }

    override fun pause() {
        player.pause()
    }

    override fun stop() {
        player.stop()
    }

    override fun release() {
        player.release()
    }
}