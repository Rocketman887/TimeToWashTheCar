package com.example.timetowashthecar.domain

import android.annotation.SuppressLint
import java.sql.Date
import java.text.SimpleDateFormat

class HourlyTimeConverter : TimeConverter{
    @SuppressLint("SimpleDateFormat")
    public override fun convert(dt:Long):String{
        val sdf = SimpleDateFormat("hh:mm")
        val netDate = Date(dt* 1000)
        return sdf.format(netDate)
    }
}