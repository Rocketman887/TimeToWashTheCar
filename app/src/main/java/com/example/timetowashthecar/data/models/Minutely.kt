package com.example.timetowashthecar.data.models

import com.google.gson.annotations.SerializedName

data class Minutely (
    @SerializedName("dt")
    var dt: Long,
    @SerializedName("precipitation")
    var precipitation: Int,
)