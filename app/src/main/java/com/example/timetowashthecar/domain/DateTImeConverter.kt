package com.example.timetowashthecar.domain

import android.annotation.SuppressLint
import java.util.*

class DateTimeConverter:TimeConverter {
    @SuppressLint("SimpleDateFormat")
    override fun convert(dt:Long): String {
        val sdf = java.text.SimpleDateFormat("")
        return sdf.format(Date())
    }
    fun dayInfo():String{
        val sdf = java.text.SimpleDateFormat("EEE, d MMM yyyy")
        return sdf.format(Date())
    }
}