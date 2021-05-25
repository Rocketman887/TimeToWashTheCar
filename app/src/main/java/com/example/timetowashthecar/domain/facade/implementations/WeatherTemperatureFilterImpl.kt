package com.example.timetowashthecar.domain.facade.implementations

import com.example.timetowashthecar.domain.dto.WeeklyAnalyzeDTO
import com.example.timetowashthecar.domain.facade.interfacies.WeatherTemperatureFilter

class WeatherTemperatureFilterImpl:WeatherTemperatureFilter {
    override fun doFilter(listDTO:List<WeeklyAnalyzeDTO>):List<WeeklyAnalyzeDTO>{
        for(i in 1..listDTO.size - 3){
            listDTO[i].isGood = (listDTO[i].temp> -10)&&(listDTO[i+1].temp>-10)
        }
        return listDTO
    }
}