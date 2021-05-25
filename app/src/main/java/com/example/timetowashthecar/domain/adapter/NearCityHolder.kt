package com.example.timetowashthecar.domain

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.near_city_item.*

class NearCityHolder(
    override val containerView: View) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private var nearCity: NearCityItem? = null
    var itemClick: ((Double,Double)-> Unit)? = null

    @SuppressLint("SetTextI18n")
    fun bind(nearCity: NearCityItem){
        this.nearCity = nearCity
     /*   itemView.setOnClickListener{
            itemClick?.let { it1-> it1(nearCity.lon,nearCity.lat) }
        }*/
        with(nearCity) {
            city_name.text = nearCity.name
            temp_text.text = nearCity.temp.toString()
        }
    }

    companion object {
        fun getInstance(parent: ViewGroup) = NearCityHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.near_city_item, parent, false))
    }
}