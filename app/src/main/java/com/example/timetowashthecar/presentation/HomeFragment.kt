package com.example.timetowashthecar.presentation

import android.Manifest
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.timetowashthecar.R
import com.example.timetowashthecar.data.api.ApiFactory
import com.example.timetowashthecar.data.api.response.WeatherPart
import com.example.timetowashthecar.domain.adapter.DailyAdapter
import com.example.timetowashthecar.domain.dto.DailyItem
import com.example.timetowashthecar.domain.dto.WeeklyAnalyzeDTO
import com.example.timetowashthecar.domain.facade.ThemeImageViewResolver
import com.example.timetowashthecar.domain.facade.WeatherAnalyzeFacade
import com.example.timetowashthecar.domain.facade.WeatherIconResolver
import com.example.timetowashthecar.domain.helper.DateTimeHelper
import com.example.timetowashthecar.domain.helper.WeatherHelper
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList
import kotlin.coroutines.CoroutineContext

class HomeFragment() : Fragment(), CoroutineScope {
    private var job = SupervisorJob()

    override val coroutineContext: CoroutineContext = Dispatchers.IO + job

    private lateinit var itemList: ArrayList<DailyItem>
    private lateinit var listDTO: ArrayList<WeeklyAnalyzeDTO>

    private lateinit var weatherAnalyzeFacade: WeatherAnalyzeFacade
    private lateinit var dateTimeHelper: DateTimeHelper
    private lateinit var weatherIconResolver: WeatherIconResolver
    private lateinit var weatherHelper: WeatherHelper
    private lateinit var themeImageViewResolver: ThemeImageViewResolver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dateTimeHelper = DateTimeHelper()
        weatherHelper = WeatherHelper()
        weatherIconResolver = WeatherIconResolver()
        themeImageViewResolver = ThemeImageViewResolver()

        rv_hourly_weather.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        getWeatherListAfterGrantedLocation()

        bt_location.setOnClickListener {
            getWeatherListAfterGrantedLocation()
        }
        bt_settings.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }
        bt_find_wash.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_cityChoiceFragment)
        }
    }

    private fun getWeatherListAfterGrantedLocation() {
        activity?.let { activity ->
            val mFusedLocationClient =
                LocationServices.getFusedLocationProviderClient(activity)
            if (ActivityCompat.checkSelfPermission(
                    activity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
                != PackageManager.PERMISSION_GRANTED && ActivityCompat
                    .checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            mFusedLocationClient.lastLocation.addOnSuccessListener(activity) { location: Location ->
                launch {

                    val weatherResponse = ApiFactory.getWeatherByCoord(
                        location.latitude, location.longitude,
                        WeatherPart.minutely
                    )

                    val geoCoder = Geocoder(context, Locale.getDefault())
                    val addresses: List<Address> =
                        geoCoder.getFromLocation(location.latitude, location.longitude, 1)
                    val result = addresses[0]

                    activity?.runOnUiThread {
                        tv_description.text = weatherResponse.current.weather[0].description
                        tv_day_temperature.text =
                            "${weatherHelper.degConvert(weatherResponse.daily[0].temp.day)}°"
                        tv_day_info.text =
                            "${result.countryName}, ${result.adminArea},\n${dateTimeHelper.dayInfo()}"

                        tv_feels_like_temperature.text =
                            "${weatherHelper.degConvert(weatherResponse.daily[0].temp.night)}°"
                        tv_wp2_pressure.text =
                            "${weatherHelper.pressureConvert(weatherResponse.current.pressure).toString()}mmHG"
                        tv_wp2_humidity.text = "${weatherResponse.current.humidity}%"
                        tv_wp2_wind_speed.text =
                            "${weatherHelper.windSpeedConvert(weatherResponse.current.wind_speed)}m/s"

                        var backgroundDrawableName =
                            weatherIconResolver.findPicture(weatherResponse.current.weather[0].icon)
                        iv_description.setBackgroundResource(backgroundDrawableName)

                        iv_car.setImageResource(themeImageViewResolver.findPicture(weatherResponse.current.weather[0].main))

                        listDTO = ArrayList()
                        weatherResponse.daily.forEach { daily ->
                            listDTO.add(
                                WeeklyAnalyzeDTO(
                                    weatherHelper.degConvert(daily.temp.day),
                                    dateTimeHelper.convert(daily.dt),
                                    daily.weather[0].main,
                                    false
                                )
                            )
                        }

                        weatherAnalyzeFacade = WeatherAnalyzeFacade()
                        val res = weatherAnalyzeFacade.analyze(listDTO)

                        itemList = ArrayList()
                        weatherResponse.daily.forEach { daily ->
                            itemList.add(
                                DailyItem(
                                    daily.dt,
                                    daily.temp.day,
                                    daily.weather[0].icon
                                )
                            )
                        }
                        activity?.runOnUiThread {
                            itemList.forEach() {
                                rv_hourly_weather.adapter = DailyAdapter(itemList)
                            }
                            tv_recommendation.text = res
                        }
                    }
                }
            }
        }

    }
}