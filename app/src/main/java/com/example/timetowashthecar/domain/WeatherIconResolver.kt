package com.example.timetowashthecar.domain

import java.lang.reflect.Field


class WeatherIconResolver {

    fun findPicture(icon_id: String): String {
        return when (icon_id) {
            "02d", "02n", "03d", "03n", "04d", "04n" -> "clouds"
            "09d", "09n" -> "drizzle"
            "10d", "10n" -> "rain"
            "13d", "13n" -> "snow"
            "11d", "11n" -> "thunderstorm"
            "50d", "50n" -> "atmospehere"

            else -> "clear"
        }
    }
    fun getLayoutBackgroundDrawableId(resourceName: String, c: Class<*>): Int {
        try {
            val idField: Field = c.getDeclaredField(resourceName)
            return idField.getInt(idField)
        } catch (e: Exception) {
            throw RuntimeException(
                "No resource ID found for: $resourceName / $c, $e"
            )
        }
    }
}