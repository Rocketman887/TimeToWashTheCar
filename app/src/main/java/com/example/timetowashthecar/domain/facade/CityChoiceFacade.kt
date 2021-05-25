package com.example.timetowashthecar.domain.facade

import com.example.timetowashthecar.domain.dto.CityChoiceItem

class CityChoiceFacade {
    private val cityChoiceList:ArrayList<CityChoiceItem> = ArrayList()
    private fun addCityChoiceToList(){
        cityChoiceList.add(CityChoiceItem(0,"Moscow","Russia"))
        cityChoiceList.add(CityChoiceItem(1,"Kazan","Russia"))
        cityChoiceList.add(CityChoiceItem(2,"Los Angeles","USA"))
        cityChoiceList.add(CityChoiceItem(3,"London","England"))
        cityChoiceList.add(CityChoiceItem(4,"Paris","France"))
        cityChoiceList.add(CityChoiceItem(5,"Tokyo","Japan"))
    }
    fun getCityChoiceList():ArrayList<CityChoiceItem>{
        cityChoiceList.clear()
        addCityChoiceToList()
        return cityChoiceList
    }

}