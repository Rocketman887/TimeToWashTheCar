package com.example.timetowashthecar.data.api.dto

import com.google.gson.annotations.SerializedName

data class Daily (
    @SerializedName("dt")
    var dt:Long,
    @SerializedName("temp")
    var temp: Temp,
    @SerializedName("weather")
    var weather: List<Weather>,

    )