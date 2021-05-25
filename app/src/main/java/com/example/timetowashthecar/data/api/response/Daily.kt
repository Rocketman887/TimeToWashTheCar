package com.example.timetowashthecar.data.api.response

import com.google.gson.annotations.SerializedName

data class Daily (
    @SerializedName("dt")
    var dt:Long,
    @SerializedName("temp")
    var temp: Temp,
    @SerializedName("weather")
    var weather: List<Weather>,

    )