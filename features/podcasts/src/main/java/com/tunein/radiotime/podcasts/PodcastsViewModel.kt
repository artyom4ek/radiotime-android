package com.tunein.radiotime.podcasts

import javax.inject.Inject

import androidx.lifecycle.ViewModel

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.navigation.Navigator

/**
 * [PodcastsViewModel] class for the Podcasts screen.
 *
 * @param navigator The Navigator interface implementation used for navigation between screens.
 */
@HiltViewModel
class PodcastsViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel(), Navigator by navigator