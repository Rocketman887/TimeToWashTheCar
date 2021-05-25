package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.database.entity.MapCache

interface MapLocalDataSource {
     suspend fun getMapData(city:String):List<MapCache>
     suspend fun insertMapData(mapCacheList:List<MapCache>)
     suspend fun updateMapData(mapCacheList:List<MapCache>)
}