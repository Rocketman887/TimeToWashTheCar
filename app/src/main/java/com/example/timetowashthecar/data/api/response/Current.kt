package com.example.timetowashthecar.data.api.response

import com.google.gson.annotations.SerializedName

data class Current (
    @SerializedName("dt")
    var dt: Long,
    @SerializedName("temp")
    var temp: Double,
    @SerializedName("pressure")
    var pressure: Int,
    @SerializedName("humidity")
    var humidity: Int,
    @SerializedName("wind_speed")
    var wind_speed: Double,
    @SerializedName("weather")
    var weather: List<Weather>
    )