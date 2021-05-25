package com.example.timetowashthecar.domain

import com.example.timetowashthecar.R
import java.lang.reflect.Field


class WeatherIconResolver {

    fun findPicture(icon_id: String): Int {
        return when (icon_id) {
            "02d", "02n", "03d", "03n", "04d", "04n" -> R.drawable.clouds
            "09d", "09n" -> R.drawable.drizzle
            "10d", "10n" -> R.drawable.rain
            "13d", "13n" -> R.drawable.snow
            "11d", "11n" -> R.drawable.thunderstorm
            "50d", "50n" -> R.drawable.atmospehere

            else -> R.drawable.clear
        }
    }
}