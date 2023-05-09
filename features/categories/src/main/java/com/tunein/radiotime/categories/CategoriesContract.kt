package com.tunein.radiotime.categories

import com.tunein.radiotime.common.mvi.UiEffect
import com.tunein.radiotime.common.mvi.UiEvent
import com.tunein.radiotime.common.mvi.UiState
import com.tunein.radiotime.domain.model.CategoryItem

/**
 * Contract of Categories Screen
 */
class CategoriesContract {

    sealed class Event : UiEvent {
        object OnInitCategories : Event()
    }

    data class State(
        val categoriesState: CategoriesState,
    ) : UiState

    sealed class CategoriesState {
        object Loading : CategoriesState()
        object Empty : CategoriesState()
        data class Success(val categories: List<CategoryItem>) : CategoriesState()
    }

    sealed class Effect : UiEffect {
        data class ShowError(val message: String?) : Effect()
    }
}