package com.tunein.radiotime.categorydetails

import javax.inject.Inject

import kotlinx.coroutines.launch

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.common.mvi.BaseViewModel
import com.tunein.radiotime.domain.usecase.CategoryDetailsUseCase
import com.tunein.radiotime.navigation.Navigator
import com.tunein.radiotime.navigation.destinations.CategoryDetailsDestination

@HiltViewModel
class CategoryDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val navigator: Navigator,
    private val categoryDetailsUseCase: CategoryDetailsUseCase
) : BaseViewModel<CategoryDetailsContract.Event, CategoryDetailsContract.State, CategoryDetailsContract.Effect>(),
    Navigator by navigator {

    // Get Url param from previous screen
    private val url
        get() = savedStateHandle.get<String>(CategoryDetailsDestination.CATEGORY_DETAILS_URL_PARAM)

    init {
        setEvent(CategoryDetailsContract.Event.OnInitCategoryDetails)
    }

    override fun createInitialState(): CategoryDetailsContract.State {
        return CategoryDetailsContract.State(
            categoryDetailsState = CategoryDetailsContract.CategoryDetailsState.Loading,
        )
    }

    override fun handleEvent(event: CategoryDetailsContract.Event) {
        when (event) {
            is CategoryDetailsContract.Event.OnInitCategoryDetails -> {
                initCategoryDetails()
            }
        }
    }

    private fun initCategoryDetails() {
        viewModelScope.launch {
            if (url == null) {
                setEffect { CategoryDetailsContract.Effect.ShowError(message = "Url must be defined") }
            } else {
                val categories = categoryDetailsUseCase.getCategoryDetails(url!!)
                if (categories.isEmpty()) {
                    setState { copy(categoryDetailsState = CategoryDetailsContract.CategoryDetailsState.Empty) }
                } else {
                    setState {
                        copy(
                            categoryDetailsState = CategoryDetailsContract.CategoryDetailsState.Success(
                                categories
                            )
                        )
                    }
                }
            }
        }
    }
}
