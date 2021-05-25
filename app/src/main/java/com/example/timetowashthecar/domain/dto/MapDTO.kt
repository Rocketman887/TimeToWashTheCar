package com.example.timetowashthecar.domain.dto

import androidx.room.ColumnInfo

data class MapDTO (
    val lat: Double,
    val lon: Double,
    val name: String,
    val rate:Double,
    val city:String,
    var country:String,
    val address: String
        )