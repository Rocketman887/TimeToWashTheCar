package com.example.timetowashthecar.domain.facade

import com.example.timetowashthecar.R

class MainImageViewResolver {
    fun findPicture(main: String): Int {
        return when (main) {
            "Clouds" -> R.drawable.cloud_case
            "Rain","Drizzle" -> R.drawable.rain_case
            "Snow" -> R.drawable.snow_case
            "Thunderstorm" -> R.drawable.thunderstorm_case
            "Atmosphere" -> R.drawable.atmosphere_case
            "Clear" -> R.drawable.clear_case
            else -> R.drawable.clear_case
        }
    }
}