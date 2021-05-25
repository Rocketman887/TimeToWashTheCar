package com.example.timetowashthecar.data.api.response

import com.google.gson.annotations.SerializedName

data class Wind(@SerializedName("speed")
                var speed: Double)