package com.example.timetowashthecar.domain.dto


data class DailyDTO(
    var temp:Int,
    var icon_id: String,
    var date:String,
    val main:String
    )