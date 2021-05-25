package com.example.timetowashthecar.domain.helper

class WeatherHelper {
    fun degConvert(temp: Double): Int {
        return (((temp-32)*5)/9).toInt()
    }
    fun pressureConvert(press:Int):Int{
        return ((press/1.33).toInt())
    }
    fun windSpeedConvert(windSpeed:Double):Int{
        return windSpeed.toInt()
    }
}