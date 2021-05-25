package com.example.timetowashthecar.domain.facade.interfacies

import com.example.timetowashthecar.domain.dto.WeeklyAnalyzeDTO

interface WeatherDescriptionFilter {
    fun doFilter(listDTO: List<WeeklyAnalyzeDTO>):List<WeeklyAnalyzeDTO>
}