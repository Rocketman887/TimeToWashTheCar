package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.database.entity.CurrentCache
import com.example.timetowashthecar.data.database.entity.CurrentDao

class CurrentLocalDataSourceImpl(private val currentDao: CurrentDao): CurrentLocalDataSource {
    override suspend fun getLastCurrentData(): CurrentCache = currentDao.getCurrentCache()
    override suspend fun insertCurrentData(currentCache: CurrentCache) = currentDao.insert(currentCache)
    override suspend fun updateCurrentCache(currentCache: CurrentCache) = currentDao.update(currentCache)
}