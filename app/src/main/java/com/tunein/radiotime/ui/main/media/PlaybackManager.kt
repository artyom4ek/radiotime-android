package com.tunein.radiotime.ui.main.media

/**
 * [PlaybackManager] is an interface that defines the methods for managing audio playback.
 */
interface PlaybackManager {
    
    /**
     * Handles the playback error by invoking the provided callback function with the error message.
     * @param onPlaybackError Callback function to handle the playback error with the error message as a parameter.
     **/
    fun handlePlaybackError(onPlaybackError: (String) -> Unit)

    /**
     * Plays the audio from the specified URL.
     * @param url The URL of the audio to be played.
     */
    fun play(url: String)

    /**
     * Resumes playback if it was paused.
     */
    fun play()

    /**
     * Pauses the current playback.
     */
    fun pause()

    /**
     * Stops the current playback.
     */
    fun stop()

    /**
     * Releases any resources associated with the playback manager.
     */
    fun release()
}