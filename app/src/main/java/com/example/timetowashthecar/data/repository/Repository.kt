package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.entity.*
import com.example.timetowashthecar.data.dto.CoordResponse
import com.example.timetowashthecar.data.dto.NearCityListResponse
import com.example.timetowashthecar.data.dto.OneCallWeatherResponse

class LocalRepository (
    private val remoteDataSource: RetrofitDataSource,
    private val currentLocalDataSource: CurrentLocalDataSourceImpl,
    private val dailyLocalDataSource: DailyLocalDataSourceImpl,
    private val mapLocalDataSource: MapLocalDataSourceImpl,
)
{
    suspend fun getOneCallWeather(lat:Double, lon:Double): OneCallWeatherResponse = remoteDataSource.getOneCallWeather(lat, lon)
    suspend fun getCityCoord(name: String):CoordResponse = remoteDataSource.getCityCoord(name)
    suspend fun getCityCoordList(lat: Double,lon: Double): NearCityListResponse = remoteDataSource.getCityCoordList(lat,lon)
    suspend fun getLastCurrentData(): CurrentCache = currentLocalDataSource.getLastCurrentData()
    suspend fun getLastDailyData():List<DailyCache> = dailyLocalDataSource.getDailyCache()
    suspend fun getMapData(city:String):List<MapCache> = mapLocalDataSource.getMapData(city)

    suspend fun insertCurrentData(currentCache: CurrentCache) = currentLocalDataSource.insertCurrentData(currentCache)
    suspend fun insertDailyData(dailyCacheList:List<DailyCache>) = dailyLocalDataSource.insertDailyCache(dailyCacheList)
    suspend fun insertMapData(mapCacheList:List<MapCache>) = mapLocalDataSource.insertMapData(mapCacheList)

    suspend fun updateCurrentData(currentCache: CurrentCache) = currentLocalDataSource.updateCurrentCache(currentCache)
    suspend fun updateDailyData(dailyCacheList:List<DailyCache>) = dailyLocalDataSource.updateDailyCache(dailyCacheList)
    suspend fun updateMapData(mapCacheList:List<MapCache>) = mapLocalDataSource.updateMapData(mapCacheList)

}