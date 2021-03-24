package com.example.timetowashthecar.data.models

import com.google.gson.annotations.SerializedName

data class Current (
    @SerializedName("dt")
    var dt: Long,
    @SerializedName("sunrise")
    var sunrise: Long,
    @SerializedName("sunset")
    var sunset: Long,
    @SerializedName("temp")
    var temp: Double,
    @SerializedName("feels_like")
    var feels_like: Double,
    @SerializedName("pressure")
    var pressure: Int,
    @SerializedName("humidity")
    var humidity: Int,
    @SerializedName("dew_point")
    var dew_point: Double,
    @SerializedName("clouds")
    var clouds: Int,
    @SerializedName("uvi")
    var uvi: String,
    @SerializedName("visibility")
    var visibility: Int,
    @SerializedName("wind_speed")
    var wind_speed: Double,
    @SerializedName("weather")
    var weather: List<Weather>
    )