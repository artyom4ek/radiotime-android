package com.tunein.radiotime.home

import javax.inject.Inject
import androidx.lifecycle.ViewModel

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.navigation.Navigator

/**
 * [HomeViewModel] class for the Details screen.
 *
 * @param navigator The Navigator interface implementation used for navigation between screens.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel(), Navigator by navigator
