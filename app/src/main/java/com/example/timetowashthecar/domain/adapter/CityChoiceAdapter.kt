package com.example.timetowashthecar.domain

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CityChoiceAdapter (
    private var list: List<CityChoiceItem>,
    private val itemClick: (id:Int) -> Unit
    ): RecyclerView.Adapter<CityChoiceHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityChoiceHolder =
            CityChoiceHolder.getInstance(parent,itemClick)

        override fun onBindViewHolder(holder: CityChoiceHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount(): Int = list.size

        fun updateDataList(newList: List<CityChoiceItem>){
            list = newList
            notifyDataSetChanged()
        }
}