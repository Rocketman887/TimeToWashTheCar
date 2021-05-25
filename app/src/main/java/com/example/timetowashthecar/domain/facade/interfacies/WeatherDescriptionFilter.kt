package com.example.timetowashthecar.domain.interfacies

import com.example.timetowashthecar.domain.dto.WeeklyAnalyzeDTO

interface WeatherDescriptionFilter {
    fun doFilter(listDTO: List<WeeklyAnalyzeDTO>):List<WeeklyAnalyzeDTO>
}