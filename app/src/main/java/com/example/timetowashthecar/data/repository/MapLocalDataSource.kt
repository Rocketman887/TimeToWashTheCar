package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.database.MapDao

interface MapLocalDataSource {
    suspend fun getLastMapData(city:String):List<MapDao>
    suspend fun insertMapData()
}