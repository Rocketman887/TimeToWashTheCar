package com.example.timetowashthecar.domain

import android.net.Uri

data class HourlyWeather(
    var time: Long,
    var temp: Double,
    var iconUri: String
)