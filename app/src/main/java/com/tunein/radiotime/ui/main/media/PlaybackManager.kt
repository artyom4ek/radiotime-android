package com.tunein.radiotime.ui.main.media

interface PlaybackManager {
    fun play(url: String)
    fun play()
    fun pause()
    fun stop()
    fun release()
}