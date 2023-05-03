package com.tunein.radiotime.data.api

import retrofit2.http.GET
import retrofit2.http.Url
import retrofit2.http.Query

import com.tunein.radiotime.data.entity.ResponseDto
import com.tunein.radiotime.data.entity.radio.RadioResponseDto

/**
 * The main services that handles all endpoint processes
 */
interface ApiService {

    @GET("Browse.ashx")
    suspend fun fetchInitialData(@Query("render") render: String = "json"): ResponseDto

    @GET
    suspend fun fetchRadioStations(
        @Url url: String, // Dynamic URL
        @Query("render") render: String = "json"
    ): RadioResponseDto
}