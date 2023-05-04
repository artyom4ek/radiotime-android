package com.tunein.radiotime

import javax.inject.Inject

import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.common.mvi.BaseViewModel
import com.tunein.radiotime.domain.usecase.MainUseCase
import com.tunein.radiotime.domain.usecase.PodcastsUseCase
import com.tunein.radiotime.domain.usecase.RadioUseCase
import com.tunein.radiotime.ui.main.MainContract

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase,
    private val radioUseCase: RadioUseCase,
    private val podcastsUseCase: PodcastsUseCase,
) : BaseViewModel<MainContract.Event, MainContract.State, MainContract.Effect>() {

    init {
        setEvent(MainContract.Event.OnInitMainData)
    }

    private fun prepareInitialData() {
        viewModelScope.launch {

            // Get initial data with tabs info
            val initialData = mainUseCase.getInitialData()

            // Populate the Radio tab with data
            val radioTab = initialData.radioTab
            radioTab.url?.let {
                radioTab.radioStations.addAll(
                    radioUseCase.getRadioStations(it)
                )
            }

            // Populate the Podcasts tab with data
            val podcastsTab = initialData.podcastsTab
            podcastsTab.url?.let {
                podcastsTab.podcastCategories.addAll(
                    podcastsUseCase.getPodcastCategories(it)
                )
            }

            setState { copy(mainState = MainContract.MainState.Success(initialData)) }
        }
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
        }
    }
}