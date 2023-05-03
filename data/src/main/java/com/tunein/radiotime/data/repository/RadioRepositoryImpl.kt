package com.tunein.radiotime.data.repository

import javax.inject.Inject

import kotlinx.serialization.json.Json

import retrofit2.Retrofit
import okhttp3.MediaType.Companion.toMediaType

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory

import com.tunein.radiotime.common.mapper.Mapper
import com.tunein.radiotime.common.network.Constants
import com.tunein.radiotime.data.api.ApiService
import com.tunein.radiotime.data.entity.radio.RadioItemDto
import com.tunein.radiotime.domain.model.RadioStation
import com.tunein.radiotime.domain.repository.RadioRepository

class RadioRepositoryImpl @Inject constructor(
    private val retrofit: Retrofit,
    private val mapper: Mapper<RadioStation, RadioItemDto>
) : RadioRepository {

    override suspend fun getRadioStations(url: String): List<RadioStation> {
        val contentType = "application/json".toMediaType()
        val json = Json {
            ignoreUnknownKeys = true
        }

        // Create a new request to get data for the Radio tab
        val response = retrofit.newBuilder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(ApiService::class.java)
            .fetchRadioStations(url)

        // The JSON struct returns an array that contains one element
        return mapper.toList(response.body[0].items)
    }
}