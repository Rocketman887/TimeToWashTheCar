package com.example.timetowashthecar.domain

import androidx.room.TypeConverter
import com.example.timetowashthecar.data.database.entity.CurrentCache
import com.example.timetowashthecar.data.database.entity.DailyCache
import com.example.timetowashthecar.data.database.entity.MapCache
import com.example.timetowashthecar.domain.dto.CurrentDTO
import com.example.timetowashthecar.domain.dto.DailyDTO
import com.example.timetowashthecar.domain.dto.MapDTO

class ResponseToDTOConverter {
    companion object {

        @TypeConverter
        fun mapFromDTOToCurrent(dto: CurrentDTO): CurrentCache {
            with(dto) {
                return CurrentCache(
                    0,
                    dto.lastLat,
                    dto.lastLon,
                    dto.lastLoc,
                    dto.lastPressure,
                    dto.lastHumidity,
                    dto.lastWindSpeed,
                    dto.iconId,
                    dto.description,
                    dto.last_analysis_result
                )
            }
        }

        @TypeConverter
        fun mapFromCurrentToDTO(cache: CurrentCache): CurrentDTO {
            with(cache) {
                return CurrentDTO(
                    cache.lastLat,
                    cache.lastLon,
                    cache.lastLoc,
                    cache.lastPressure,
                    cache.lastHumidity,
                    cache.lastWindSpeed,
                    cache.iconId,
                    cache.description,
                    cache.last_analysis_result
                )
            }
        }

        @TypeConverter
        fun mapFromMapToDTO(cacheList: ArrayList<MapCache>): ArrayList<MapDTO> {
            var mapDtoList = ArrayList<MapDTO>()
            cacheList.forEach() {
                with(it) {
                    mapDtoList.add(
                        MapDTO(
                            it.lat,
                            it.lon,
                            it.name,
                            it.rate,
                            it.city,
                            it.country,
                            it.address
                        )
                    )
                }
            }
            return mapDtoList
        }

        @TypeConverter
        fun mapFromDailyToDTO(cacheList: ArrayList<DailyCache>): ArrayList<DailyDTO> {
            var dailyDtoList = ArrayList<DailyDTO>()
            cacheList.forEach() {
                with(it) {
                    dailyDtoList.add(
                        DailyDTO(
                            it.temp,
                            it.iconId,
                            it.date,
                            it.main
                        )
                    )
                }
            }
            return dailyDtoList
        }

        @TypeConverter
        fun mapFromDTOToDaily(dtoList: ArrayList<DailyDTO>): ArrayList<DailyCache> {
            var i = 0
            val dailyCacheList = ArrayList<DailyCache>()
            dtoList.forEach() {
                with(it) {
                    dailyCacheList.add(
                        DailyCache(
                            i,
                            it.date,
                            it.temp,
                            it.icon_id,
                            it.main
                        )
                    )
                    i++
                }
            }
            return dailyCacheList
        }


    }
}
