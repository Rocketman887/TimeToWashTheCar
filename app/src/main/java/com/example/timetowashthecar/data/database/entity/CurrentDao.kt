package com.example.timetowashthecar.data.entity

import androidx.room.*

@Dao
public interface CurrentDao {

    @Query("SELECT*FROM current_cache WHERE id = 0")
    fun getCurrentCache():CurrentCache

    @Insert
    fun insert(currentCache: CurrentCache)

    @Insert
    fun update(currentCache: CurrentCache)

    @Delete
    fun delete(currentCache: CurrentCache)
}