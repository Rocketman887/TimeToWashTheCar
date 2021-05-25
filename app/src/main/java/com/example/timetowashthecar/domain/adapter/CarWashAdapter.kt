package com.example.timetowashthecar.domain.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.domain.dto.CarWashItem

class CarWashAdapter (
    private var list: List<CarWashItem>,
    private val itemClick: (lat: Double,lon: Double) -> Unit
    ): RecyclerView.Adapter<CarWashHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarWashHolder =
            CarWashHolder.getInstance(parent, itemClick)

        override fun onBindViewHolder(holder: CarWashHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount(): Int = list.size

        fun updateDataList(newList: List<CarWashItem>){
            list = newList
            notifyDataSetChanged()
        }

}