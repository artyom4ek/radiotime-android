package com.tunein.radiotime.ui.main.media

interface PlaybackManager {
    fun handlePlaybackError(onPlaybackError: (String) -> Unit)
    fun play(url: String)
    fun play()
    fun pause()
    fun stop()
    fun release()
}