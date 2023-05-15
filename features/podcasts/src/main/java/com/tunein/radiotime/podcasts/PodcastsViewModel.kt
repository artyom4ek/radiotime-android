package com.tunein.radiotime.podcasts

import javax.inject.Inject

import androidx.lifecycle.ViewModel

import dagger.hilt.android.lifecycle.HiltViewModel

import com.tunein.radiotime.navigation.Navigator

@HiltViewModel
class PodcastsViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel(), Navigator by navigator