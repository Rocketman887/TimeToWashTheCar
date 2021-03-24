package com.example.timetowashthecar.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "current_weather")
data class CachedCurrentWeather (
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "wind_speed")
    var windDeg: Int,
    @ColumnInfo(name = "temp")
    var temp: Double,
    @ColumnInfo(name = "feels_like")
    var feelsLike: Double,
    @ColumnInfo(name = "humidity")
    var humidity: Int,
    @ColumnInfo(name = "pressure")
    var pressure: Int,
    @ColumnInfo(name = "dew_point")
    var dew_point:Double
        )