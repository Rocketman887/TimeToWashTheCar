package com.example.timetowashthecar.domain.facade.implementations

import com.example.timetowashthecar.domain.dto.WeeklyAnalyzeDTO
import com.example.timetowashthecar.domain.facade.interfacies.WeatherDescriptionFilter

class WeatherDescriptionFilterImpl:WeatherDescriptionFilter {
    companion object{
        val badWeather = listOf("Thunderstorm","Drizzle","Rain","Sand","Dust")
    }
   override fun doFilter(listDTO:List<WeeklyAnalyzeDTO>):List<WeeklyAnalyzeDTO> {
       for (i in 1..listDTO.size - 3) {
           if (listDTO[i].isGood)
               listDTO[i].isGood = ((!badWeather.contains(listDTO[i].description))
                       && (!badWeather.contains(listDTO[i - 1].description))
                       && (!badWeather.contains(listDTO[i + 1].description))
                       && (!badWeather.contains(listDTO[i + 2].description)))
       }
       return listDTO
   }
}