package com.example.timetowashthecar.domain

data class WeatherAnalysisItem (
    var id:Int,
    var day_info:String,
    var description:String,
    var advice:String,
    var icon_uri:String,
    var temp:Double
)