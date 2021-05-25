package com.example.timetowashthecar.data.di

import com.example.timetowashthecar.data.api.WeatherAPI
import com.example.timetowashthecar.data.database.entity.CurrentDao
import com.example.timetowashthecar.data.database.entity.DailyDao
import com.example.timetowashthecar.data.database.entity.MapDao
import com.example.timetowashthecar.data.repository.*
import dagger.Module
import dagger.Provides

@Module
public class RepositoryModule {

    @Provides
    fun provideRemoteDataSource(weatherAPI: WeatherAPI):RemoteDataSource{
        return RetrofitDataSource(weatherAPI)
    }

    @Provides
    fun provideCurrentLocalDataSource(currentDao: CurrentDao):CurrentLocalDataSource{
        return CurrentLocalDataSourceImpl(currentDao)
    }

    @Provides
    fun provideDailyLocalDataSource(dailyDao: DailyDao):DailyLocalDataSource{
        return DailyLocalDataSourceImpl(dailyDao)
    }

    @Provides
    fun provideMapLocalDataSource(mapDao: MapDao):MapLocalDataSource{
        return MapLocalDataSourceImpl(mapDao)
    }
}