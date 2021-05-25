package com.example.timetowashthecar.data.api.dto

import com.google.gson.annotations.SerializedName

data class OneCallWeatherResponse(
        @SerializedName("id")
        var id: Int,
        @SerializedName("lat")
        var lat: Double,
        @SerializedName("lon")
        var lon: Double,
        @SerializedName("current")
        var current: Current,
        @SerializedName("daily")
        var daily: List<Daily>
)