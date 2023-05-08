package com.tunein.radiotime.categories

import javax.inject.Inject

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.navigation.Navigator

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val navigator: Navigator,
) : ViewModel(), Navigator by navigator {

}