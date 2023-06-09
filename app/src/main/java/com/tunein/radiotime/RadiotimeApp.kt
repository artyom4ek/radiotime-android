package com.tunein.radiotime

import android.app.Application
import timber.log.Timber

import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RadiotimeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}