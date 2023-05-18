package com.tunein.radiotime.ui.main

import javax.inject.Inject

import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.common.mvi.BaseViewModel
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
            currentSong = null,
            selectedSong = null
        )
    }

    override fun handleEvent(event: MainContract.Event) {
        when (event) {
            is MainContract.Event.OnInitMainData -> {
                prepareInitialData()
            }

            is MainContract.Event.PlayAudio -> {
                playAudio(event.url)
            }

            MainContract.Event.StopAudio -> {
                stopAudio()
            }
        }
    }

    private fun prepareInitialData() {
        viewModelScope.launch {

            // Get initial data with tabs info
            val initialData = mainUseCase.getInitialData()

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
    }

    private fun playAudio(url: String) {
        viewModelScope.launch {
            uiState.value.currentSong?.let { playbackManager.stop() }

            val audioUrl = mediaUseCase.getAudioData(url)
            playbackManager.play(audioUrl)

            setSong(url)
        }
    }

    private fun stopAudio() {
        playbackManager.stop()
        setSong(null)
    }

    private fun setSong(url: String?) {
        setState { copy(currentSong = url) }
        setState { copy(selectedSong = url) }
    }
}