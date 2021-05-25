package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.database.DailyCache
import com.example.timetowashthecar.data.database.DailyDao

class DailyLocalDataSourceImpl(private val dailyDao: DailyDao): DailyLocalDataSource {
    override suspend fun getDailyCache():List<DailyCache> = dailyDao.getAll()
    override suspend fun insertDailyCache(dailyCacheList: List<DailyCache>) = dailyDao.insertAll(dailyCacheList)
    override suspend fun updateDailyCache(dailyCacheList: List<DailyCache>) = dailyDao.updateAll(dailyCacheList)

}