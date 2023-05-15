package com.tunein.radiotime.content

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope

import javax.inject.Inject

import kotlinx.coroutines.launch

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.common.mvi.BaseViewModel
import com.tunein.radiotime.domain.model.BaseTab
import com.tunein.radiotime.domain.usecase.PodcastsUseCase
import com.tunein.radiotime.navigation.Navigator
import com.tunein.radiotime.navigation.destinations.DetailsDestination

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val navigator: Navigator,
    private val podcastsUseCase: PodcastsUseCase
) : BaseViewModel<DetailsContract.Event, DetailsContract.State, DetailsContract.Effect>(),
    Navigator by navigator {

    // Get Url param from previous screen
    private val urlParam
        get() = savedStateHandle.get<String>(DetailsDestination.DETAILS_URL_PARAM)

    init {
        setEvent(DetailsContract.Event.OnInitContent)
    }

    override fun createInitialState(): DetailsContract.State {
        return DetailsContract.State(
            detailsState = DetailsContract.DetailsState.Loading,
        )
    }

    override fun handleEvent(event: DetailsContract.Event) {
        when (event) {
            is DetailsContract.Event.OnInitContent -> {
                initCategories()
            }
        }
    }

    private fun initCategories() {
        viewModelScope.launch {
            val detailsUrl = urlParam
            if (detailsUrl == null) {
                setEffect { DetailsContract.Effect.ShowError(message = "Url must be defined") }
            } else {
                val data = podcastsUseCase.getParsedData(detailsUrl)

                if (data.isEmpty()) {
                    setState { copy(detailsState = DetailsContract.DetailsState.Empty) }
                } else {
                    val hasTabs = data[0] is BaseTab
                    setState {
                        copy(
                            detailsState = DetailsContract.DetailsState.Success(
                                Pair(data, hasTabs)
                            )
                        )
                    }
                }
            }
        }
    }
}