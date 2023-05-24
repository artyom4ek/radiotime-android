package com.tunein.radiotime.content

import com.tunein.radiotime.common.mvi.UiEffect
import com.tunein.radiotime.common.mvi.UiEvent
import com.tunein.radiotime.common.mvi.UiState
import com.tunein.radiotime.domain.model.CategoryType

/**
 * Contract of Details Screen.
 */
class DetailsContract {

    sealed class Event : UiEvent {
        object OnInitContent : Event()
    }

    data class State(
        val detailsState: DetailsState,
    ) : UiState

    sealed class DetailsState {
        object Loading : DetailsState()
        object Empty : DetailsState()
        data class Success(val items: Pair<List<CategoryType>, Boolean>) : DetailsState()
    }

    sealed class Effect : UiEffect {
        data class ShowError(val message: String) : Effect()
    }
}