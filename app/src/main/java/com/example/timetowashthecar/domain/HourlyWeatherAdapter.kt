package com.example.timetowashthecar.domain

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class HourlyWeatherAdapter (
    private var list: List<HourlyWeatherItem>,

    ): RecyclerView.Adapter<HourlyWeatherHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyWeatherHolder =
        HourlyWeatherHolder.getInstance(parent)

    override fun onBindViewHolder(holder: HourlyWeatherHolder, position: Int) {
        holder.mImageView?.let {
            Glide.with(holder.itemView.getContext())
                .load(list.get(position).iconUri)
                .into(it)
        }
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateDataList(newList: List<HourlyWeatherItem>){
        list = newList
        notifyDataSetChanged()
    }
}