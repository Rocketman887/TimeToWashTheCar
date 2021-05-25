package com.example.timetowashthecar.data.api.dto

import com.google.gson.annotations.SerializedName

data class CoordResponse (
    @SerializedName("id")
    var id: Int,
    @SerializedName("coord")
    var coord: Coord,
    @SerializedName("name")
    var name: String,
    @SerializedName("main")
    var main: Main
    )