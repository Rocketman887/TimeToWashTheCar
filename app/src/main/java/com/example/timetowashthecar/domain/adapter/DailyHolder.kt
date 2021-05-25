package com.example.timetowashthecar.domain

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.rl_weekly_weather.*

class DailyHolder(
    override val containerView: View,
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private var dateTimeConverter = DateTimeConverter()
    private var temperatureConverter = TemperatureConverter()
    private var dailyItem: DailyItem? = null
    private var weatherIconResolver = WeatherIconResolver()

/*
    var mImageView: ImageView? = itemView.findViewById(R.id.iv_weather)
*/

    @SuppressLint("SetTextI18n")
    fun bind(dailyItem: DailyItem) {
        this.dailyItem = dailyItem
        with(dailyItem) {
            tv_weekly_temperature.text = temperatureConverter.degConvert(temp)
            tv_date.text = dateTimeConverter.convertRV(time)
            iv_weather.setImageResource(weatherIconResolver.findPicture(description))
        }
    }

    companion object {
        fun getInstance(parent: ViewGroup) = DailyHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rl_weekly_weather, parent,
                false
            )
        )
    }
}