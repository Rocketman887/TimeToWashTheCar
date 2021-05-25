package com.example.timetowashthecar.domain.dto

data class CurrentWeatherData(
    var currentTemp:Int,
    var minTemp: Int,
    var dt:String,
    var description:String,
)