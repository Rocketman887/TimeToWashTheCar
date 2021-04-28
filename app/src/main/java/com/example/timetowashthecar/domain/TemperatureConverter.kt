package com.example.timetowashthecar.domain

import com.example.timetowashthecar.R

class TemperatureConverter {
    fun degConvert(temp: Double): String {
        return "${(((temp-32)*5)/9).toInt()}°"
    }
}