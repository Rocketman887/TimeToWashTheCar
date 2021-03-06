package com.example.timetowashthecar.domain.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.domain.dto.DailyItem

class DailyAdapter (
    private var list: List<DailyItem>,

    ): RecyclerView.Adapter<DailyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyHolder =
        DailyHolder.getInstance(parent)

    override fun onBindViewHolder(holder: DailyHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateDataList(newList: List<DailyItem>){
        list = newList
        notifyDataSetChanged()
    }
}