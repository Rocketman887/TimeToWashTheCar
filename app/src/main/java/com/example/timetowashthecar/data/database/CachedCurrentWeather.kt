package com.example.timetowashthecar.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.timetowashthecar.data.dto.Weather

@Entity(tableName = "current_weather")
data class CachedCurrentWeather (
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "dt")
    var dt: Long,
    @ColumnInfo(name = "sunrise")
    var sunrise: Long,
    @ColumnInfo(name = "sunset")
    var sunset: Long,
    @ColumnInfo(name = "temp")
    var temp: Double,
    @ColumnInfo(name = "feels_like")
    var feels_like: Double,
    @ColumnInfo(name = "pressure")
    var pressure: Int,
    @ColumnInfo(name = "humidity")
    var humidity: Int,
    @ColumnInfo(name = "dew_point")
    var dew_point: Double,
    @ColumnInfo(name = "clouds")
    var clouds: Int,
    @ColumnInfo(name = "uvi")
    var uvi: String,
    @ColumnInfo(name = "visibility")
    var visibility: Int,
    @ColumnInfo(name = "wind_speed")
    var wind_speed: Double,
    @ColumnInfo(name = "weather")
    var weather: List<Weather>
        )
