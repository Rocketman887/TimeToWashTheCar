package com.example.timetowashthecar.domain

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NearCityAdapter(
    private var list: List<NearCityItem>,
    //private val itemClick: (Double,Double)->Unit
    ): RecyclerView.Adapter<NearCityHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearCityHolder {
        return NearCityHolder.getInstance(parent)//.also { it.itemClick = itemClick }
    }

    override fun onBindViewHolder(holder: NearCityHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateDataList(newList: List<NearCityItem>){
        list = newList
        notifyDataSetChanged()
    }
}