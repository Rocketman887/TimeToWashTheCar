package com.example.timetowashthecar.data.dto

import com.example.timetowashthecar.data.dto.Hourly
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherResponse(
        @SerializedName("id")
        var id: Int,
        @SerializedName("lat")
        var lat: Double,
        @SerializedName("lon")
        var lon: Double,
        @SerializedName("timezone")
        var timezone: String,
        @SerializedName("timezone_offset")
        var timezoneOffset: Long,
        @SerializedName("current")
        var current: Current,
        @SerializedName("hourly")
        var hourly: List<Hourly>,
        @SerializedName("daily")
        var daily: List<Daily>
):Serializable