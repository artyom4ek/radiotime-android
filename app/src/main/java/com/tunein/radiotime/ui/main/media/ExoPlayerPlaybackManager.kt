package com.tunein.radiotime.ui.main.media

import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer

import javax.inject.Inject

/**
 * [ExoPlayerPlaybackManager] is a class that implements the PlaybackManager interface using Media3 library.
 * @param player The ExoPlayer instance used for audio playback.
 */
class ExoPlayerPlaybackManager @Inject constructor(
    private val player: ExoPlayer
) : PlaybackManager {

    override fun handlePlaybackError(onPlaybackError: (String) -> Unit) {
        player.addListener(object : Player.Listener {

            override fun onPlayerError(error: PlaybackException) {
                super.onPlayerError(error)
                onPlaybackError(error.message ?: "Playback error")
            }

            override fun onPlayerErrorChanged(error: PlaybackException?) {
                super.onPlayerErrorChanged(error)
                onPlaybackError(error?.message ?: "Playback error")
            }
        })
    }

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