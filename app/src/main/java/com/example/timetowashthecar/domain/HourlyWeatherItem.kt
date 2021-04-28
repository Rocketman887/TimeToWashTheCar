package com.example.timetowashthecar.domain

data class HourlyWeatherItem(
    var time: Long,
    var temp: Double,
    var iconUri: String
)