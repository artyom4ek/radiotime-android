package com.tunein.radiotime

import javax.inject.Inject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import kotlinx.coroutines.launch

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.domain.usecase.MainUseCase

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            prepareInitialData()
        }
    }

    private suspend fun prepareInitialData() {
        mainUseCase.getInitialData()
    }
}