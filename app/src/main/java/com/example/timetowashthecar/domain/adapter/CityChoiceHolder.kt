package com.example.timetowashthecar.domain

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.car_wash_item.*
import kotlinx.android.synthetic.main.city_item.*

class CityChoiceHolder(
    override val containerView: View,
    private val itemClick: (id:Int) -> Unit
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private var cityChoiceItem: CityChoiceItem? = null

    @SuppressLint("SetTextI18n")
    fun bind(cityChoiceItem: CityChoiceItem) {
        this.cityChoiceItem = cityChoiceItem
        itemView.setOnClickListener {
            itemClick(cityChoiceItem.id)
        }
        with(cityChoiceItem) {
            tv_city_item.text = "${cityChoiceItem.city}, ${cityChoiceItem.country}"
        }
    }

    companion object {
        fun getInstance(parent: ViewGroup, itemClick: (id:Int) -> Unit) = CityChoiceHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.city_item, parent, false),itemClick)
    }
}