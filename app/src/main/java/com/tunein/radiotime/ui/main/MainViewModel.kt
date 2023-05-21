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

    private fun prepareInitialData() {
        viewModelScope.launch {

            mainUseCase.getInitialData()
                .onStart { emit(Resource.Loading) }
                .collect {
                    when (it) {
                        is Resource.Loading -> {
                            setState { copy(mainState = MainContract.MainState.Loading) }
                        }

                        is Resource.Success -> {
                            // Get initial data with tabs info
                            val initialData = it.data

                            // Populate the Radio tab with data
                            val radioTab = initialData.radioTab
                            radioTab.url?.let {
                                radioTab.stations.addAll(
                                    radioUseCase.getRadioStations(it)
                                )
                            }

                            // Populate the Podcasts tab with data
                            val podcastsTab = initialData.podcastsTab
                            podcastsTab.url?.let {
                                podcastsTab.categories.addAll(
                                    podcastsUseCase.getPodcastCategories(it)
                                )
                            }

                            setState { copy(mainState = MainContract.MainState.Success(initialData)) }
                        }

                        is Resource.Error -> {
                            setEffect { MainContract.Effect.ShowError(message = it.exception.message) }
                        }

                        else -> {
                            Timber.d(it.toString())
                        }
                    }
                }
        }
    }

    private fun playAudio(audioItem: AudioItem) {
        viewModelScope.launch {
            val currentTrack = uiState.value.currentTrack
            val isPlaying = uiState.value.isPlaying
            if (currentTrack == audioItem.url) {
                if (isPlaying) {
                    playbackManager.play()
                } else {
                    playbackManager.pause()
                }
                setState { copy(isPlaying = !isPlaying) }
            } else {
                currentTrack?.let { playbackManager.stop() }
                val audioUrl = mediaUseCase.getAudioData(audioItem.url)
                playbackManager.play(audioUrl)
                setState { copy(audioItem = audioItem) }
                setTrack(audioItem.url)
            }
        }
    }

    private fun stopAudio() {
        playbackManager.stop()
        setState { copy(isPlaying = false) }
        setState { copy(audioItem = null) }
        setTrack(null)
    }

    private fun setTrack(url: String?) {
        setState { copy(currentTrack = url) }
        setState { copy(selectedTrack = url) }
    }

    private fun releasePlayer() {
        playbackManager.release()
    }
}