package com.example.timetowashthecar.domain.facade

import com.example.timetowashthecar.domain.helper.DateTimeHelper
import com.example.timetowashthecar.domain.dto.WeeklyAnalyzeDTO
import com.example.timetowashthecar.domain.facade.implementations.WeatherDescriptionFilterImpl
import com.example.timetowashthecar.domain.facade.implementations.WeatherTemperatureFilterImpl

class WeatherAnalyzeFacade {
    private val weatherDescriptionFilter = WeatherDescriptionFilterImpl()
    private val weatherTemperatureFilter = WeatherTemperatureFilterImpl()
    private var resultDate: String? = null
    companion object{
        private val dateTimeConverter = DateTimeHelper()
        var todayDate = dateTimeConverter.dayInfo()
    }
    fun analyze(listDTO:List<WeeklyAnalyzeDTO>):String{
        val listDTO1 = weatherTemperatureFilter.doFilter(listDTO)
        val listDTO2 = weatherDescriptionFilter.doFilter(listDTO1)
        for(i in 1..listDTO2.size-3){
            if(listDTO2[i].isGood) {
                resultDate = "The best time to wash your car is ${listDTO2[i].date}"
                break
            }
        }
        if (resultDate==null){
            resultDate = "It's better not to wash your car on this week"
        }
        return resultDate as String;
    }
}