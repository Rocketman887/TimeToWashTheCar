package com.example.timetowashthecar.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_cache")
class DailyCache (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "temp")
    val temp: Int,
    @ColumnInfo(name = "icon_id")
    val iconId: String,
    @ColumnInfo(name = "main")
    val main:String
        )