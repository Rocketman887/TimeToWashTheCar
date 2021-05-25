package com.example.timetowashthecar.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.timetowashthecar.R
import com.example.timetowashthecar.domain.adapter.CityChoiceAdapter
import com.example.timetowashthecar.domain.facade.CityChoiceFacade
import kotlinx.android.synthetic.main.fragment_city_choice.*
import kotlinx.android.synthetic.main.fragment_search.*

class CityChoiceFragment: Fragment() {

    private lateinit var cityChoiceFacade: CityChoiceFacade
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city_choice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cityChoiceFacade = CityChoiceFacade()


        val cityChoiceAdapter = CityChoiceAdapter(cityChoiceFacade.getCityChoiceList()){
            navigateToCarWashes(it)
        }
        rv_city.adapter = cityChoiceAdapter


    }

    fun navigateToCarWashes(city:String){
        findNavController().navigate(R.id.action_cityChoiceFragment_to_carWashesFragment)
    }
}