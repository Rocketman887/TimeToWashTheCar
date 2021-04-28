package com.example.timetowashthecar.data.dto

import com.google.gson.annotations.SerializedName

data class Daily (
    @SerializedName("dt")
    var dt:Long,
    @SerializedName("temp")
    var temp: Temp,
    @SerializedName("feels_like")
    var feels_like: FeelsLike,
    @SerializedName("pressure")
    var pressure: Int,
    @SerializedName("humidity")
    var humidity: Int,
    @SerializedName("dew_point")
    var dew_point: Double,
    @SerializedName("uvi")
    var uvi: String,
    @SerializedName("clouds")
    var clouds: Int,
    @SerializedName("visibility")
    var visibility: Int,
    @SerializedName("wind_speed")
    var wind_speed: Double,
    @SerializedName("weather")
    var weather: List<Weather>,

    )