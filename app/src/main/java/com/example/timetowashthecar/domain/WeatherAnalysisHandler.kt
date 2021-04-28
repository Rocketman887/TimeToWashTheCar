package com.example.timetowashthecar.domain


class WeatherAnalysisHandler : WeatherAnalysis {

    override fun analyzeByDescription(description: String): Boolean {
        return when (description) {
            "Clear", "Clouds", "Fog", "Smoke", "Haze" -> true
            "Rain", "Drizzle", "Thunderstorm", "Sand", "Dust", "Ash", "Squall", "Tornado" -> false
            else -> false
        }
    }

    override fun analyzeByTemp(temp: Int): Boolean {
        if (temp > -10) {
            return true
        } else
            if (temp < -10) {
                return false
            }
        return false

    }

    private fun result(description: String, temp: Int): Boolean {
        return analyzeByDescription(description) && analyzeByTemp(temp)
    }

    fun giveAdvice(description: String, temp: Int): String {
        return if (result(description, temp)) {
            "You may wash the car in this day"
        } else {
            "You shouldn't wash the car in this day"
        }
    }

}
