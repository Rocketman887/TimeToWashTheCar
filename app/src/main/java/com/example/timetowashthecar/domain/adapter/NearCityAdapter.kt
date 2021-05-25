package com.example.timetowashthecar.domain.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.domain.dto.NearCityItem

class NearCityAdapter(
    private var list: List<NearCityItem>,
    private val itemClick: (nearCityItem:NearCityItem) -> Unit
    ): RecyclerView.Adapter<NearCityHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearCityHolder {
        return NearCityHolder.getInstance(parent,itemClick)
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