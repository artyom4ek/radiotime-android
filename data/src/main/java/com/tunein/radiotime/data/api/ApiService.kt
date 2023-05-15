package com.tunein.radiotime.data.api

import retrofit2.http.GET
import retrofit2.http.Url
import retrofit2.http.Query

import com.tunein.radiotime.data.entity.InitialDataResponseDto
import com.tunein.radiotime.data.entity.categoryDetails.ResponseWithChildrenDto
import com.tunein.radiotime.data.entity.main.CategoriesResponseDto
import com.tunein.radiotime.data.entity.podcast.PodcastsResponseDto
import com.tunein.radiotime.data.entity.radio.RadioResponseDto
import com.tunein.radiotime.data.entity.response.ResponseDto

/**
 * The main services that handles all endpoint processes
 */
interface ApiService {

    @GET("Browse.ashx")
    suspend fun fetchInitialData(@Query("render") render: String = "json"): InitialDataResponseDto

    @GET
    suspend fun fetchRadioStations(
        @Url url: String, // Dynamic URL
        @Query("render") render: String = "json"
    ): RadioResponseDto

    @GET
    suspend fun fetchPodcastCategories(
        @Url url: String,
        @Query("render") render: String = "json"
    ): PodcastsResponseDto

    @GET
    suspend fun fetchCategories(
        @Url url: String,
        @Query("render") render: String = "json"
    ): CategoriesResponseDto

    @GET
    suspend fun fetchDataWithChildren(
        @Url url: String,
        @Query("render") render: String = "json"
    ): ResponseWithChildrenDto

    @GET
    suspend fun fetchRawDataByUrl(
        @Url url: String,
        @Query("render") render: String = "json"
    ): ResponseDto
}