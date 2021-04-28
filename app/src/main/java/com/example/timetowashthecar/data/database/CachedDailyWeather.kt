package com.example.timetowashthecar.data.database

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.timetowashthecar.data.dto.Temp
import com.example.timetowashthecar.data.dto.Weather
import com.example.timetowashthecar.data.dto.WeatherResponse

class CachedDailyWeather (
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "dt")
    var dt:Long,
    @ColumnInfo(name = "temp")
    var temp: Temp,
    @ColumnInfo(name = "weather")
    var weather: List<Weather>,
){
    companion object {
        fun mapFromResponse(
            response: WeatherResponse,
            lat: Double,
            lon: Double
        ): CachedDailyWeather {
            with(response) {
                return CachedDailyWeather(
                    id, daily[0].dt,
                    daily[0].temp,
                    daily[0].weather
                )
            }
        }
    }
}