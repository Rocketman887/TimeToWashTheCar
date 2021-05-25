package com.example.timetowashthecar.data.api.dto

import com.google.gson.annotations.SerializedName

data class Wind(@SerializedName("speed")
                var speed: Double)