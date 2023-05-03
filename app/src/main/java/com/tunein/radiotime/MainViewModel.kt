package com.tunein.radiotime

import javax.inject.Inject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.domain.usecase.MainUseCase
import com.tunein.radiotime.domain.usecase.PodcastsUseCase
import com.tunein.radiotime.domain.usecase.RadioUseCase

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase,
    private val radioUseCase: RadioUseCase,
    private val podcastsUseCase: PodcastsUseCase,
) : ViewModel() {

    init {
        viewModelScope.launch {
            prepareInitialData()
        }
    }

    private suspend fun prepareInitialData() {

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
    }
}