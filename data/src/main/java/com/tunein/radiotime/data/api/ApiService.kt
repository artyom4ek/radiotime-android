package com.tunein.radiotime.data.api

import retrofit2.http.GET
import retrofit2.http.Url
import retrofit2.http.Query

import com.tunein.radiotime.data.entity.main.InitialDataResponseDto
import com.tunein.radiotime.data.entity.response.ResponseDto

/**
 * The main services that handles all endpoint processes
 */
interface ApiService {

    @GET("Browse.ashx")
    suspend fun fetchInitialData(@Query("render") render: String = "json"): InitialDataResponseDto

    @GET
    suspend fun fetchRawDataByUrl(
        @Url url: String,
        @Query("render") render: String = "json"
    ): ResponseDto
}