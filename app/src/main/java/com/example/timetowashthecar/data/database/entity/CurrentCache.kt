package com.example.timetowashthecar.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current_cache")
class CurrentCache (
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "last_lat")
    val lastLat: Double,
    @ColumnInfo(name = "last_lon")
    val lastLon: Double,
    @ColumnInfo(name = "last_location")
    val lastLoc:String,
    @ColumnInfo(name = "last_pressure")
    val lastPressure:Int,
    @ColumnInfo(name = "last_humidity")
    val lastHumidity:Int,
    @ColumnInfo(name = "last_wind_speed")
    val lastWindSpeed:Int,
    @ColumnInfo(name = "icon_id")
    val iconId:Int,
    @ColumnInfo(name = "description")
    val description:String,
    @ColumnInfo(name = "last_analysis_result")
    val last_analysis_result:String
)