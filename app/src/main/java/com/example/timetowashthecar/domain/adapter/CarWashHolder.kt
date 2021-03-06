package com.example.timetowashthecar.domain.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.R
import com.example.timetowashthecar.domain.dto.CarWashItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.car_wash_item.*

class CarWashHolder(
    override val containerView: View,
    private val itemClick: (lat: Double,lon: Double) -> Unit
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private var carWashItem: CarWashItem? = null

    fun bind(carWashItem: CarWashItem) {
        this.carWashItem = carWashItem
        containerView.setOnClickListener {
            itemClick(carWashItem.lat,carWashItem.lon)
        }
        with(carWashItem) {
            tv_name.text = carWashItem.name
            tv_rate.text = carWashItem.rate.toString()
            tv_address.text = carWashItem.address
        }
    }

    companion object {
        fun getInstance(parent: ViewGroup, itemClick: (lat: Double, lon: Double) -> Unit) = CarWashHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.car_wash_item, parent, false),itemClick)
    }
}