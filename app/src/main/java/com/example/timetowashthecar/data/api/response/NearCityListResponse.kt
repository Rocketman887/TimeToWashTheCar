package com.example.timetowashthecar.data.api.response

import com.google.gson.annotations.SerializedName

data class NearCityListResponse (@SerializedName("list")
                                 var weather_list: List<CoordResponse>)