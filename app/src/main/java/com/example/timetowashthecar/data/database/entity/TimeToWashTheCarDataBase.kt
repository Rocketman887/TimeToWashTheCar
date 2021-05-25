package com.example.timetowashthecar.data.entity
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val DATABASE_NAME = "com.timetowashthecar.weather.db"

@Database(entities = [CurrentCache::class, DailyCache::class, MapCache::class], version = 1)
abstract class TimeToWashTheCarDataBase : RoomDatabase() {
    companion object {
        private lateinit var sInstance: TimeToWashTheCarDataBase
        @Synchronized
        fun getInstance(context: Context): TimeToWashTheCarDataBase {
            if (!Companion::sInstance.isInitialized) {
                sInstance = Room.databaseBuilder(context, TimeToWashTheCarDataBase::class.java,
                        DATABASE_NAME
                ).
                build()
            }
            return sInstance
        }
    }
}
