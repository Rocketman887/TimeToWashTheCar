package com.example.timetowashthecar.domain

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HourlyWeatherAdapter (
    private var list: List<HourlyWeather>,

    ): RecyclerView.Adapter<HourlyWeatherHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyWeatherHolder =
        HourlyWeatherHolder.getInstance(parent)

    override fun onBindViewHolder(holder: HourlyWeatherHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateDataList(newList: List<HourlyWeather>){
        list = newList
        notifyDataSetChanged()
    }
}