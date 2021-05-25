package com.example.timetowashthecar.data.api.dto

import com.google.gson.annotations.SerializedName

data class NearCityListResponse (@SerializedName("list")
                                 var weather_list: List<CoordResponse>)