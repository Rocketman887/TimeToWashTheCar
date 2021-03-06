package com.example.timetowashthecar.data.api

import com.example.timetowashthecar.data.api.response.NearCityListResponse
import com.example.timetowashthecar.data.api.response.CoordResponse
import com.example.timetowashthecar.data.api.response.WeatherPart
import com.example.timetowashthecar.data.api.response.OneCallWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {


    @GET("onecall")
    suspend fun getWeatherByCoord(@Query("lat") lat: Double, @Query("lon") lon: Double,
                                         @Query("exclude") exclude: WeatherPart
    ): OneCallWeatherResponse

    @GET("weather")
    suspend fun getWeatherByName(
        @retrofit2.http.Query("q") cityName: String
    ) : CoordResponse
    @GET("find")
    suspend fun getWeatherList(@Query("lat") latitude : Double,
                               @Query("lon") longitude : Double,
                               @Query("cnt") cnt: Int ): NearCityListResponse
}