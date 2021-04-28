package com.example.timetowashthecar.domain

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.rl_hourly_weather.*

class HourlyWeatherHolder(
    override val containerView: View,
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private var hourlyTimeConverter = HourlyTimeConverter()
    private var temperatureConverter = TemperatureConverter()
    private var hourlyWeatherItem: HourlyWeatherItem? = null

    var mImageView: ImageView? = itemView.findViewById(R.id.iv_weather)

    @SuppressLint("SetTextI18n")
    fun bind(hourlyWeatherItem: HourlyWeatherItem) {
        this.hourlyWeatherItem = hourlyWeatherItem
        with(hourlyWeatherItem) {
            tv_hourly_temperature.text = temperatureConverter.degConvert(temp)
            tv_time.text = hourlyTimeConverter.convert(time)
        }
    }

    companion object {
        fun getInstance(parent: ViewGroup) = HourlyWeatherHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rl_hourly_weather, parent, false
            )
        )
    }
}