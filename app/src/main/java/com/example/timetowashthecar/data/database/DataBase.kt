package com.example.timetowashthecar.data.database
/*
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


const val DATABASE_NAME = "com.timetowashthecar.weather.db"

@Database(entities = [CachedCurrentWeather::class, CachedDailyWeather::class, CachedHourlyWeather::class], version = 1)
abstract class DataBase : RoomDatabase() {
    companion object {
        private lateinit var sInstance: DataBase
        @Synchronized
        fun getInstance(context: Context): DataBase {
            if (!Companion::sInstance.isInitialized) {
                sInstance = Room.databaseBuilder(context, DataBase::class.java,
                        DATABASE_NAME
                ).
                build()
            }
            return sInstance
        }
    }
}

 */