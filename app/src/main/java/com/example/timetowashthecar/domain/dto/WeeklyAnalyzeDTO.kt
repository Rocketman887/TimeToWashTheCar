package com.example.timetowashthecar.domain.dto

data class WeeklyAnalyzeDTO (
    var temp:Int,
    var date:String,
    var description:String,
    var isGood:Boolean
)