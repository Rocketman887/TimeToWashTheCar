package com.example.timetowashthecar.domain

interface WeatherAnalysis {
    fun analyzeByDescription(description:String):Boolean
    fun analyzeByTemp(temp:Int):Boolean
}