package com.tunein.radiotime.categorydetails

import javax.inject.Inject
import androidx.lifecycle.ViewModel

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.navigation.Navigator

@HiltViewModel
class CategoryDetailsViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel(), Navigator by navigator
