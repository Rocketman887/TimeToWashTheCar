package com.example.timetowashthecar.data.entity

import androidx.room.*

@Dao
public interface DailyDao {

    @Query("SELECT * FROM daily_cache")
    fun getAll():List<DailyCache>

    @Insert
    fun insert(dailyCache: DailyCache)

    @Insert
    fun insertAll(dailyCacheList:List<DailyCache>)

    @Update
    fun update(dailyCache: DailyCache)

    @Update
    fun updateAll(dailyCacheList: List<DailyCache>)

    @Delete
    fun delete(dailyCache: DailyCache)
}