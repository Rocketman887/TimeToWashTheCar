package com.example.timetowashthecar.domain.dto

data class CurrentDTO(
    val lastLat: Double,
    val lastLon: Double,
    val lastLoc:String,
    val lastPressure:Int,
    val lastHumidity:Int,
    val lastWindSpeed:Int,
    val iconId: String,
    val description:String,
    val last_analysis_result:String
)