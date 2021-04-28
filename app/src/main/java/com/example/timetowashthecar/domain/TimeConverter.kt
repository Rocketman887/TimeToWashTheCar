package com.example.timetowashthecar.domain

interface TimeConverter {
    fun convert(dt:Long):String;
}