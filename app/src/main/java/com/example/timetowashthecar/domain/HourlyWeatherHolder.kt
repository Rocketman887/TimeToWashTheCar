package com.example.timetowashthecar.domain

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_home.tv_temperature
import kotlinx.android.synthetic.main.rl_hourly_weather.*

class HourlyWeatherHolder (
    override val containerView: View,
    ) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

        private var hourlyWeather: HourlyWeather? = null

        @SuppressLint("SetTextI18n")
        fun bind(hourlyWeather: HourlyWeather){
            this.hourlyWeather = hourlyWeather
            with(hourlyWeather) {
                tv_hourly_temperature.text = temp.toString()
                tv_time.text = time.toString()
            }
        }

        companion object {
            fun getInstance(parent: ViewGroup) = HourlyWeatherHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.rl_hourly_weather, parent, false))
        }
}