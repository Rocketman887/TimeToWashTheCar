package com.example.timetowashthecar.domain

import androidx.room.TypeConverter
import com.example.timetowashthecar.data.api.response.OneCallWeatherResponse
import com.example.timetowashthecar.domain.dto.CurrentDTO
import com.example.timetowashthecar.domain.dto.DailyDTO
import com.example.timetowashthecar.domain.helper.DateTimeHelper
import com.example.timetowashthecar.domain.helper.WeatherHelper
import java.util.ArrayList

class ResponseConverter {
    companion object {
        private val weatherHelper = WeatherHelper()
        private val dateTimeHelper = DateTimeHelper()

        @TypeConverter
        fun mapFromResponseToCurrentDTO(
            response: OneCallWeatherResponse,
            location: String,
            result:String
        ): CurrentDTO {
            with(response) {
                return CurrentDTO(
                    response.lat,
                    response.lon,
                    "$location,\n${dateTimeHelper.dayInfo()} ",
                    weatherHelper.pressureConvert(response.current.pressure),
                    response.current.humidity,
                    weatherHelper.windSpeedConvert(response.current.wind_speed),
                    response.current.weather[0].icon,
                    response.current.weather[0].main,
                    result
                )
            }
        }

        @TypeConverter
        fun mapFromResponseToDailyDTO(
            response: OneCallWeatherResponse
        ): List<DailyDTO> {
            val dtoList = ArrayList<DailyDTO>()
            response.daily.forEach() {
            with(it) {
                    dtoList.add(
                        DailyDTO(
                            weatherHelper.degConvert(it.temp.day),
                            it.weather[0].icon,
                            dateTimeHelper.convertRV(it.dt),
                            it.weather[0].main
                        )
                    )
                }
            }
            return dtoList
        }
    }
}