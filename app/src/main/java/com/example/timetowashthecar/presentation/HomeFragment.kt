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
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.timetowashthecar.R
import com.example.timetowashthecar.data.api.ApiFactory
import com.example.timetowashthecar.data.models.WeatherPart
import com.example.timetowashthecar.domain.*
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList
import kotlin.coroutines.CoroutineContext

const val BASE_IMAGE_URI = "http://openweathermap.org/img/wn/"

class HomeFragment() : Fragment(), CoroutineScope {
    private var job = SupervisorJob()

    override val coroutineContext: CoroutineContext = Dispatchers.IO + job

    private lateinit var hourlyWeatherList: ArrayList<HourlyWeather>

    private lateinit var temperatureConverter: TemperatureConverter
    private lateinit var dateTimeConverter: DateTimeConverter

    private lateinit var ivDescription: ImageView


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

        temperatureConverter = TemperatureConverter()
        dateTimeConverter = DateTimeConverter()

        rv_hourly_weather.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
        getWeatherListAfterGrantedLocation()

        bt_location.setOnClickListener{
            getWeatherListAfterGrantedLocation()
        }


    }

    private fun getWeatherListAfterGrantedLocation() {
        activity?.let { activity ->
            val mFusedLocationClient =
                    LocationServices.getFusedLocationProviderClient(activity)
            if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat
                            .checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                Log.d("hi", "error")
                return
            }
            mFusedLocationClient.lastLocation.addOnSuccessListener(activity) { location: Location ->
                launch {
                    Log.d("Coords", "latitude: ${location.latitude.toFloat()}, longitude:${location.longitude.toFloat()}")
                    val weatherResponse = ApiFactory.getWeatherByCoord(location.latitude, location.longitude, WeatherPart.minutely)

                    val geoCoder = Geocoder(context, Locale.getDefault())
                    val addresses: List<Address> = geoCoder.getFromLocation(location.latitude, location.longitude, 1)
                    val result = addresses[0]

                    activity?.runOnUiThread {
                        tv_description.text = weatherResponse.current.weather[0].description
                        tv_temperature.text = temperatureConverter.convert(weatherResponse.current.temp)
                        tv_day_info.text = "${result.countryName}, ${result.adminArea},\n${dateTimeConverter.dayInfo()}"
                        context?.let {
                            Glide.with(it)
                                    .load("$BASE_IMAGE_URI${weatherResponse.current.weather[0].icon}.png".toUri()).into(iv_description)
                        }
                    }


                    hourlyWeatherList = ArrayList()
                    weatherResponse.hourly.forEach { hourly ->
                        hourlyWeatherList.add(
                                HourlyWeather(
                                        hourly.dt,
                                        hourly.temp,
                                        "$BASE_IMAGE_URI${hourly.weather[0].icon}.png"
                                )
                        )
                    }
                    activity?.runOnUiThread {
                        hourlyWeatherList.forEach() {
                            rv_hourly_weather.adapter = HourlyWeatherAdapter(hourlyWeatherList)
                            //context?.let { it1 -> Glide.with(it1).load(it.iconUri.toUri()).into(ivDescription) }
                        }

                    }
                }
            }
        }
    }


}