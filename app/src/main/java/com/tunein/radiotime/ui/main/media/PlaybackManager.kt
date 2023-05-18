package com.tunein.radiotime.ui.main.media

interface PlaybackManager {
    fun play(url: String)
    fun stop()
}