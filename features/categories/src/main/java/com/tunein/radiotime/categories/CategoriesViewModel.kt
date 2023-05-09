package com.tunein.radiotime.categories

import javax.inject.Inject

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.common.mvi.BaseViewModel
import com.tunein.radiotime.domain.usecase.CategoriesUseCase
import com.tunein.radiotime.navigation.Navigator
import com.tunein.radiotime.navigation.destinations.CategoriesDestination

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val navigator: Navigator,
    private val categoriesUseCase: CategoriesUseCase
) : BaseViewModel<CategoriesContract.Event, CategoriesContract.State, CategoriesContract.Effect>(),
    Navigator by navigator {

    // Get Category Url param from previous screen
    private val categoryUrl
        get() = savedStateHandle.get<String>(CategoriesDestination.CATEGORY_URL_PARAM)

    init {
        setEvent(CategoriesContract.Event.OnInitCategories)
    }

    override fun createInitialState(): CategoriesContract.State {
        return CategoriesContract.State(
            categoriesState = CategoriesContract.CategoriesState.Loading,
        )
    }

    override fun handleEvent(event: CategoriesContract.Event) {
        when (event) {
            is CategoriesContract.Event.OnInitCategories -> {
                initCategories()
            }
        }
    }

    private fun initCategories() {
        viewModelScope.launch {
            if (categoryUrl == null) {
                setEffect { CategoriesContract.Effect.ShowError(message = "Url must be defined") }
            } else {
                val categories = categoriesUseCase.getCategoriesByUrl(categoryUrl!!)
                if (categories.isEmpty()) {
                    setState { copy(categoriesState = CategoriesContract.CategoriesState.Empty) }
                } else {
                    setState {
                        copy(
                            categoriesState = CategoriesContract.CategoriesState.Success(
                                categories
                            )
                        )
                    }
                }
            }
        }
    }
}