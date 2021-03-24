package com.example.timetowashthecar.domain

class TemperatureConverter {
    fun convert(temp:Double): String {
        return "${(((temp-32)*5)/9).toInt()}°"
    }
}