package com.example.timetowashthecar.data.database

import androidx.room.ColumnInfo
import com.example.timetowashthecar.data.dto.WeatherResponse


data class CachedResponseDetails(
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "lat")
    var lat: Double,
    @ColumnInfo(name = "lon")
    var lon: Double,
    @ColumnInfo(name = "timezone")
    var timezone: String,
    @ColumnInfo(name = "timezone_offset")
    var timezoneOffset: Long,
) {
    companion object {
        fun mapFromResponse(
            response: WeatherResponse,
            lat: Double,
            lon: Double
        ): CachedResponseDetails {
            with(response) {
                return CachedResponseDetails(
                    id, lat, lon,
                    timezone, timezoneOffset,
                )
            }
        }
    }

}