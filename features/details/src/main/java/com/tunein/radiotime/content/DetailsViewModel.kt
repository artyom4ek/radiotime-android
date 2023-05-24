package com.tunein.radiotime.content

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope

import javax.inject.Inject

import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.common.mvi.BaseViewModel
import com.tunein.radiotime.common.utils.Resource
import com.tunein.radiotime.domain.model.BaseTab
import com.tunein.radiotime.domain.usecase.MainUseCase
import com.tunein.radiotime.navigation.Navigator
import com.tunein.radiotime.navigation.destinations.DetailsDestination

/**
 * ViewModel class for the Details screen.
 *
 * @param savedStateHandle The saved state handle to retrieve and store state information.
 * @param navigator The navigator to handle navigation actions.
 * @param mainUseCase The main use case to retrieve details data.
 */
@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val navigator: Navigator,
    private val mainUseCase: MainUseCase
) : BaseViewModel<DetailsContract.Event, DetailsContract.State, DetailsContract.Effect>(),
    Navigator by navigator {

    // Get Url param from previous screen.
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
                initContent()
            }
        }
    }

    private fun initContent() {
        viewModelScope.launch {
            val detailsUrl = urlParam
            if (detailsUrl == null) {
                setEffect { DetailsContract.Effect.ShowError(message = "Url must be defined") }
            } else {
                mainUseCase.getDetailsData(detailsUrl)
                    .onStart { emit(Resource.Loading) }
                    .collect {
                        when (it) {
                            is Resource.Loading -> {
                                setState {
                                    copy(detailsState = DetailsContract.DetailsState.Loading)
                                }
                            }

                            Resource.Empty -> {
                                setState {
                                    copy(detailsState = DetailsContract.DetailsState.Empty)
                                }
                            }

                            is Resource.Success -> {
                                val detailsData = it.data
                                val hasTabs = detailsData[0] is BaseTab
                                setState {
                                    copy(
                                        detailsState = DetailsContract.DetailsState.Success(
                                            Pair(detailsData, hasTabs)
                                        )
                                    )
                                }
                            }

                            is Resource.Error -> {
                                setEffect {
                                    DetailsContract.Effect.ShowError(message = it.message)
                                }
                            }
                        }
                    }
            }
        }
    }
}