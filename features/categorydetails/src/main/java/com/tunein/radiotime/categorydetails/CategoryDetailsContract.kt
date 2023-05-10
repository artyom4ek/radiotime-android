package com.tunein.radiotime.categorydetails

import com.tunein.radiotime.common.mvi.UiEffect
import com.tunein.radiotime.common.mvi.UiEvent
import com.tunein.radiotime.common.mvi.UiState
import com.tunein.radiotime.domain.model.Category

/**
 * Contract of Category Details Screen
 */
class CategoryDetailsContract {

    sealed class Event : UiEvent {
        object OnInitCategoryDetails : Event()
    }

    data class State(
        val categoryDetailsState: CategoryDetailsState,
    ) : UiState

    sealed class CategoryDetailsState {
        object Loading : CategoryDetailsState()
        object Empty : CategoryDetailsState()
        data class Success(val categories: List<Category>) : CategoryDetailsState()
    }

    sealed class Effect : UiEffect {
        data class ShowError(val message: String?) : Effect()
    }
}