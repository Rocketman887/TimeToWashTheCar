package com.example.timetowashthecar.api

import com.example.timetowashthecar.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    @GET("weather")
    suspend fun getWeatherByName(
        @retrofit2.http.Query("q") cityName: String
    ) : WeatherResponse

    @GET("weather")
    suspend fun getWeatherById(@Query("id") id: Int): WeatherResponse
}