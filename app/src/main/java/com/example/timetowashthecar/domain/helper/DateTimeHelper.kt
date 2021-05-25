package com.example.timetowashthecar.domain.helper

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class DateTimeHelper {
    @SuppressLint("SimpleDateFormat")
    fun convert(dt:Long): String {
        val sdf = SimpleDateFormat("EEE, d MMM")
        val netDate = java.sql.Date(dt * 1000)
        return sdf.format(netDate)
    }

    @SuppressLint("SimpleDateFormat")
    fun convertRV(dt: Long): String{
        val sdf = SimpleDateFormat("d MMM")
        val netDate = java.sql.Date(dt * 1000)
        return sdf.format(netDate)
    }
    @SuppressLint("SimpleDateFormat")
    fun dayInfo():String{
        val sdf = java.text.SimpleDateFormat("EEE, d MMM yyyy")
        return sdf.format(Date())
    }
}