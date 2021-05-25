package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.database.entity.MapCache
import com.example.timetowashthecar.data.database.entity.MapDao

class MapLocalDataSourceImpl(private val mapDao: MapDao) :MapLocalDataSource{
    override suspend fun getMapData(city:String):List<MapCache> = mapDao.getAllByCity(city)
    override suspend fun insertMapData(mapCacheList:List<MapCache>) = mapDao.insertAll(mapCacheList)
    override suspend fun updateMapData(mapCacheList:List<MapCache>) = mapDao.updateAll(mapCacheList)

}