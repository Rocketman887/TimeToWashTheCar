package com.example.timetowashthecar.domain.dto

data class DailyItem(
    var time: Long,
    var temp: Double,
    var description: String
)