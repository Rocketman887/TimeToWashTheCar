package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.api.WeatherAPI
import com.example.timetowashthecar.data.api.response.NearCityListResponse
import com.example.timetowashthecar.data.api.response.CoordResponse
import com.example.timetowashthecar.data.api.response.WeatherPart
import com.example.timetowashthecar.data.api.response.OneCallWeatherResponse

class RetrofitDataSource(private val weatherAPI: WeatherAPI): RemoteDataSource {
   override suspend fun getOneCallWeather(lat:Double, lon:Double):
           OneCallWeatherResponse = weatherAPI.getWeatherByCoord(lat,lon, WeatherPart.minutely)

    override suspend fun getCityCoord(name: String):
            CoordResponse = weatherAPI.getWeatherByName(name)

    override suspend fun getCityCoordList(latitude: Double, longitude: Double):
            NearCityListResponse = weatherAPI.getWeatherList(latitude,longitude,30)
}