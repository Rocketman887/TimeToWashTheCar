package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.database.entity.CurrentCache

interface CurrentLocalDataSource {
    suspend fun getLastCurrentData(): CurrentCache
    suspend fun insertCurrentData(currentCache: CurrentCache)
    suspend fun updateCurrentCache(currentCache: CurrentCache)
}