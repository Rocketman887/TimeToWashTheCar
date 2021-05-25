package com.example.timetowashthecar.domain.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.R
import com.example.timetowashthecar.domain.dto.CityChoiceItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.city_item.*

class CityChoiceHolder(
    override val containerView: View,
    private val itemClick: (city:String) -> Unit
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private var cityChoiceItem: CityChoiceItem? = null

    @SuppressLint("SetTextI18n")
    fun bind(cityChoiceItem: CityChoiceItem) {
        this.cityChoiceItem = cityChoiceItem
        itemView.setOnClickListener {
            itemClick(cityChoiceItem.city)
        }
        with(cityChoiceItem) {
            tv_city_item.text = "${cityChoiceItem.city}, ${cityChoiceItem.country}"
        }
    }

    companion object {
        fun getInstance(parent: ViewGroup, itemClick:(city:String) -> Unit) = CityChoiceHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.city_item, parent, false),itemClick)
    }
}