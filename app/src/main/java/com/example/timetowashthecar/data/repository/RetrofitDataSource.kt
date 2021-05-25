package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.api.WeatherAPI
import com.example.timetowashthecar.data.dto.NearCityListResponse
import com.example.timetowashthecar.data.dto.CoordResponse
import com.example.timetowashthecar.data.dto.WeatherPart
import com.example.timetowashthecar.data.dto.OneCallWeatherResponse

abstract class RetrofitDataSource(private val weatherAPI: WeatherAPI): RemoteDataSource {
   override suspend fun getOneCallWeather(lat:Double, lon:Double):
           OneCallWeatherResponse = weatherAPI.getWeatherByCoord(lat,lon, WeatherPart.minutely)

    override suspend fun getCityCoord(name: String):
            CoordResponse = weatherAPI.getWeatherByName(name)

    override suspend fun getCityCoordList(latitude: Double, longitude: Double):
            NearCityListResponse = weatherAPI.getWeatherList(latitude,longitude,30)
}