package com.tunein.radiotime.data.api

import retrofit2.http.GET
import retrofit2.http.Query

import com.tunein.radiotime.data.entity.ResponseDto

/**
 * The main services that handles all endpoint processes
 */
interface ApiService {

    @GET("Browse.ashx")
    suspend fun fetchInitialData(@Query("render") render: String = "json"): ResponseDto
}