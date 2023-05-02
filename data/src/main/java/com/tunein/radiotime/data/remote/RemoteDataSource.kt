package com.tunein.radiotime.data.remote

interface RemoteDataSource {

    /**
     * Fetch initial data for parsing
     */
    suspend fun fetchInitialData(): List<Any>
}