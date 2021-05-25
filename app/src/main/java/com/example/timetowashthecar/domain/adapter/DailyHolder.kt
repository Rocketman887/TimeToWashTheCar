package com.example.timetowashthecar.domain.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.R
import com.example.timetowashthecar.domain.dto.DailyItem
import com.example.timetowashthecar.domain.helper.DateTimeHelper
import com.example.timetowashthecar.domain.facade.WeatherIconResolver
import com.example.timetowashthecar.domain.helper.WeatherHelper
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.rl_weekly_weather.*

class DailyHolder(
    override val containerView: View,
) : RecyclerView.ViewHolder(containerView),
    LayoutContainer {

    private var dateTimeConverter = DateTimeHelper()
    private var weatherHelper = WeatherHelper()
    private var dailyItem: DailyItem? = null
    private var weatherIconResolver = WeatherIconResolver()


    @SuppressLint("SetTextI18n")
    fun bind(dailyItem: DailyItem) {
        this.dailyItem = dailyItem
        with(dailyItem) {
            tv_weekly_temperature.text = "${weatherHelper.degConvert(temp)}°"
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