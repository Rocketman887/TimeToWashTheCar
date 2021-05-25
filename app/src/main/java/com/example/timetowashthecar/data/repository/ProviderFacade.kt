package com.example.timetowashthecar.data.repository

import com.example.timetowashthecar.data.api.ApiFactory
import com.example.timetowashthecar.data.database.entity.TimeToWashTheCarDataBase

class ProviderFacade {
    private lateinit var repository: AppRepository
    fun injectDb(db: TimeToWashTheCarDataBase){
        repository = AppRepository(db,ApiFactory.weatherApi)
    }

}