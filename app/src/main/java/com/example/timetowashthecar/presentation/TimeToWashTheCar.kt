package com.example.timetowashthecar.presentation

import android.app.Application
import com.example.timetowashthecar.data.database.TimeToWashTheCarDataBase

class TimeToWashTheCar: Application() {
    val database by lazy { TimeToWashTheCarDataBase.getInstance(this) }
}