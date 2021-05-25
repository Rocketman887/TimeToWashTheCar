package com.example.timetowashthecar.data.repository

import androidx.room.Database
import com.example.timetowashthecar.data.api.WeatherAPI
import com.example.timetowashthecar.data.api.response.CoordResponse
import com.example.timetowashthecar.data.api.response.NearCityListResponse
import com.example.timetowashthecar.data.api.response.OneCallWeatherResponse
import com.example.timetowashthecar.data.api.response.WeatherPart
import com.example.timetowashthecar.data.database.entity.CurrentCache
import com.example.timetowashthecar.data.database.entity.DailyCache
import com.example.timetowashthecar.data.database.entity.MapCache
import com.example.timetowashthecar.data.database.entity.TimeToWashTheCarDataBase

class AppRepository(private val db:TimeToWashTheCarDataBase,private val weatherAPI: WeatherAPI) {

    suspend fun getOneCallWeather(lat:Double, lon:Double):
            OneCallWeatherResponse = weatherAPI.getWeatherByCoord(lat,lon, WeatherPart.minutely)

    suspend fun getCityCoord(name: String):
            CoordResponse = weatherAPI.getWeatherByName(name)

    suspend fun getCityCoordList(latitude: Double, longitude: Double):
            NearCityListResponse = weatherAPI.getWeatherList(latitude,longitude,30)


    suspend fun getDailyCache():List<DailyCache> = db.dailyDao().getAll()
    suspend fun insertDailyCache(dailyCacheList: List<DailyCache>) = db.dailyDao().insertAll(dailyCacheList)
    suspend fun updateDailyCache(dailyCacheList: List<DailyCache>) = db.dailyDao().updateAll(dailyCacheList)

    suspend fun getLastCurrentData(): CurrentCache = db.currentDao().getCurrentCache()
    suspend fun insertCurrentData(currentCache: CurrentCache) = db.currentDao().insert(currentCache)
    suspend fun updateCurrentCache(currentCache: CurrentCache) = db.currentDao().update(currentCache)

    suspend fun getMapData(city:String):List<MapCache> = db.mapDao().getAllByCity(city)
    suspend fun insertMapData(mapCacheList:List<MapCache>) = db.mapDao().insertAll(mapCacheList)
    suspend fun updateMapData(mapCacheList:List<MapCache>) = db.mapDao().updateAll(mapCacheList)

}