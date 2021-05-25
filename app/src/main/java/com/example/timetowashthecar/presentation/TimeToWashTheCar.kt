package com.example.timetowashthecar.presentation

import android.app.Application
import com.example.timetowashthecar.data.database.entity.*

abstract class TimeToWashTheCar: Application() {
    abstract fun mapDao(): MapDao
    abstract fun dailyDao():DailyDao
    abstract fun currentDao():CurrentDao
    val database by lazy {
        TimeToWashTheCarDataBase.getInstance(this)
        mapDao().insertAll(WiredLocationsFacade.addDefaultWiredLocationsToList())
    }

}