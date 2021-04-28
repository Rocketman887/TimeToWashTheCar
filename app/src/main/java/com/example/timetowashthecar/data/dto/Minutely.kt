package com.example.timetowashthecar.data.dto

import com.google.gson.annotations.SerializedName

data class Minutely (
    @SerializedName("dt")
    var dt: Long,
    @SerializedName("precipitation")
    var precipitation: Int,
)