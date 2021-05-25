package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.database.MapCache
import com.example.timetowashthecar.data.database.MapDao

class MapLocalDataSourceImpl(private val mapDao: MapDao) {
    suspend fun getLastMapData(city:String) = mapDao.getAllByCity(city)
    suspend fun insertMapData(mapCacheList:List<MapCache>) = mapDao.insertAll(mapCacheList)
    suspend fun updateMapData(mapCacheList:List<MapCache>) = mapDao.updateAll(mapCacheList)

}