package com.example.timetowashthecar.domain.interfacies

import com.example.timetowashthecar.domain.dto.WeeklyAnalyzeDTO

interface WeatherTemperatureFilter {
    fun doFilter(listDTO: List<WeeklyAnalyzeDTO>):List<WeeklyAnalyzeDTO>
}