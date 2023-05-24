package com.tunein.radiotime.ui.main

import timber.log.Timber

import androidx.lifecycle.viewModelScope

import javax.inject.Inject

import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.common.mvi.BaseViewModel
import com.tunein.radiotime.common.utils.Resource
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.usecase.MainUseCase
import com.tunein.radiotime.domain.usecase.MediaUseCase
import com.tunein.radiotime.domain.usecase.PodcastsUseCase
import com.tunein.radiotime.domain.usecase.RadioUseCase
import com.tunein.radiotime.ui.main.media.PlaybackManager

/**
 * [MainViewModel] for the main screen.
 * Responsible for managing the state of the main screen and interacting with the appropriate
 * use cases and components.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val playbackManager: PlaybackManager,
    private val mainUseCase: MainUseCase,
    private val radioUseCase: RadioUseCase,
    private val podcastsUseCase: PodcastsUseCase,
    private val mediaUseCase: MediaUseCase,
) : BaseViewModel<MainContract.Event, MainContract.State, MainContract.Effect>() {

    init {
        setEvent(MainContract.Event.OnInitMainData)
        setEvent(MainContract.Event.HandlePlaybackError)
    }

    override fun createInitialState(): MainContract.State {
        return MainContract.State(
            mainState = MainContract.MainState.Loading,
        )
    }

    override fun handleEvent(event: MainContract.Event) {
        when (event) {
            is MainContract.Event.OnInitMainData -> {
                prepareInitialData()
            }

            MainContract.Event.HandlePlaybackError -> {
                handlePlaybackError()
            }

            is MainContract.Event.PlayAudio -> {
                playAudio(event.audioItem)
            }

            MainContract.Event.StopAudio -> {
                stopAudio()
            }

            MainContract.Event.ReleasePlayer -> {
                releasePlayer()
            }
        }
    }

    // The initial data is used to prepopulate the tab screens.
    private fun prepareInitialData() {
        viewModelScope.launch {
            mainUseCase.getInitialData()
                .onStart { emit(Resource.Loading) }
                .collect { resource ->
                    when (resource) {
                        is Resource.Loading -> {
                            setState { copy(mainState = MainContract.MainState.Loading) }
                        }

                        is Resource.Success -> {
                            // Get initial data with tabs info.
                            val initialData = resource.data

                            // Populate the Radio tab with data.
                            val radioTab = initialData.radioTab
                            radioTab.url?.let {
                                radioTab.stations.addAll(
                                    radioUseCase.getRadioStations(it)
                                )
                            }

                            // Populate the Podcasts tab with data.
                            val podcastsTab = initialData.podcastsTab
                            podcastsTab.url?.let {
                                podcastsTab.categories.addAll(
                                    podcastsUseCase.getPodcastCategories(it)
                                )
                            }

                            setState { copy(mainState = MainContract.MainState.Success(initialData)) }
                        }

                        is Resource.Error -> {
                            setEffect { MainContract.Effect.ShowError(message = resource.message) }
                        }

                        else -> {
                            Timber.d(resource.toString())
                        }
                    }
                }
        }
    }

    // The method implements the logic for starting an Audio item.
    private fun playAudio(audioItem: AudioItem) {
        viewModelScope.launch {
            val currentAudioItem = uiState.value.currentAudioItem?.url
            val isPlaying = uiState.value.isPlaying
            if (currentAudioItem == audioItem.url) {
                if (isPlaying) {
                    playbackManager.play()
                } else {
                    playbackManager.pause()
                }
                setState { copy(isPlaying = !isPlaying) }
            } else {
                // If the Audio Item is in playback, then you need to stop it and start a new one.
                currentAudioItem?.let { playbackManager.stop() }
                val audioUrl = mediaUseCase.getAudioData(audioItem.url)
                playbackManager.play(audioUrl)
                setState { copy(currentAudioItem = audioItem) }
            }
        }
    }

    private fun stopAudio() {
        playbackManager.stop()
        setState { copy(isPlaying = false) }
        setState { copy(currentAudioItem = null) }
    }

    // The method should be called after the lifecycle states have changed.
    private fun releasePlayer() {
        playbackManager.release()
    }

    private fun handlePlaybackError() {
        playbackManager.handlePlaybackError {
            setEffect {
                MainContract.Effect.ShowError(message = it)
            }
        }
    }
}