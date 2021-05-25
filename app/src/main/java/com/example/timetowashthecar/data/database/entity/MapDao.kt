package com.example.timetowashthecar.data.database.entity

import androidx.room.*

@Dao
public interface MapDao {

    @Query("SELECT * FROM map_cache WHERE city = :city")
    fun getAllByCity(city:String):List<MapCache>

    @Insert
    fun insertAll(mapCacheList:List<MapCache>)

    @Update
    fun updateAll(mapCacheList:List<MapCache>)

    @Insert
    fun insert(mapCache: MapCache)

    @Update
    fun update(mapCache: MapCache)

    @Delete
    fun delete(mapCache: MapCache)
}