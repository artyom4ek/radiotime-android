package com.tunein.radiotime.ui.main

import com.tunein.radiotime.common.mvi.UiEffect
import com.tunein.radiotime.common.mvi.UiEvent
import com.tunein.radiotime.common.mvi.UiState
import com.tunein.radiotime.domain.model.AudioItem
import com.tunein.radiotime.domain.model.InitialData

/**
 * [MainContract] contract of Main Screen.
 */
class MainContract {

    sealed class Event : UiEvent {
        object OnInitMainData : Event()
        class PlayAudio(val audioItem: AudioItem) : Event()
        object StopAudio : Event()
        object ReleasePlayer : Event()
        object HandlePlaybackError : Event()
    }

    data class State(
        val mainState: MainState,
        val isPlaying: Boolean = false,
        val currentAudioItem: AudioItem? = null,
    ) : UiState

    sealed class MainState {
        object Loading : MainState()
        data class Success(val initialData: InitialData) : MainState()
    }

    sealed class Effect : UiEffect {
        data class ShowError(val message: String) : Effect()
    }
}