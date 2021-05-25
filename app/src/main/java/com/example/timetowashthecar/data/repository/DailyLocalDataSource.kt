package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.database.DailyCache

interface DailyLocalDataSource{
    suspend fun getDailyCache():List<DailyCache>
    suspend fun insertDailyCache(dailyCacheList: List<DailyCache>)
    suspend fun updateDailyCache(dailyCacheList: List<DailyCache>)
}