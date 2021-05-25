package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.dto.NearCityListResponse
import com.example.timetowashthecar.data.dto.CoordResponse
import com.example.timetowashthecar.data.dto.OneCallWeatherResponse

interface RemoteDataSource {

    suspend fun getOneCallWeather(lat:Double, lon:Double):OneCallWeatherResponse
    suspend fun getCityCoord(name:String):CoordResponse
    suspend fun getCityCoordList(latitude: Double, longitude: Double): NearCityListResponse

}