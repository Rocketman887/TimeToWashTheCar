package com.example.timetowashthecar.data.database

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.timetowashthecar.data.dto.Weather
import com.example.timetowashthecar.data.dto.WeatherResponse

data class CachedHourlyWeather(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "dt")
    var dt: Long,
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
    @ColumnInfo(name = "uvi")
    var uvi: String,
    @ColumnInfo(name = "clouds")
    var clouds: Int,
    @ColumnInfo(name = "visibility")
    var visibility: Int,
    @ColumnInfo(name = "wind_speed")
    var wind_speed: Double,
    @ColumnInfo(name = "weather")
    var weather: List<Weather>
) {
    companion object {
        fun mapFromResponse(
            response: WeatherResponse,
            lat: Double,
            lon: Double
        ): CachedHourlyWeather {
            with(response) {
                return CachedHourlyWeather(
                    id, hourly[0].dt,hourly[0].temp,
                    hourly[0].feels_like,hourly[0].pressure,
                    hourly[0].humidity,hourly[0].dew_point,
                    hourly[0].uvi,hourly[0].clouds,
                    hourly[0].visibility,hourly[0].wind_speed,
                    hourly[0].weather
                )
            }
        }
    }
}