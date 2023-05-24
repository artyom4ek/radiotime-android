package com.tunein.radiotime.navigation

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * [NavigatorModule] provides dependencies related to Navigation logic.
 */
@Module
@InstallIn(SingletonComponent::class)
internal abstract class NavigatorModule {

    @Binds
    abstract fun navigator(navigator: NavigatorImpl): Navigator
}