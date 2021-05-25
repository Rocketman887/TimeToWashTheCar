package com.example.timetowashthecar.domain.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.R
import com.example.timetowashthecar.domain.dto.NearCityItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.near_city_item.*

class NearCityHolder(
    override val containerView: View,
    private val itemClick: (nearCityItem:NearCityItem) -> Unit) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private var nearCity: NearCityItem? = null

    @SuppressLint("SetTextI18n")
    fun bind(nearCity: NearCityItem){
        this.nearCity = nearCity
            itemView.setOnClickListener {
                itemClick(nearCity)
            }
        with(nearCity) {
            city_name.text = nearCity.name
            temp_text.text = nearCity.temp.toString()
        }
    }

    companion object {
        fun getInstance(parent: ViewGroup, itemClick: (nearCityItem:NearCityItem) -> Unit) = NearCityHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.near_city_item, parent, false), itemClick)
    }
}