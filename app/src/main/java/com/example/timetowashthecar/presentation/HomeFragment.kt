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
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.timetowashthecar.R
import com.example.timetowashthecar.data.api.ApiFactory
import com.example.timetowashthecar.data.dto.WeatherPart
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

    private lateinit var hourlyWeatherItemList: ArrayList<HourlyWeatherItem>

    private lateinit var temperatureConverter: TemperatureConverter
    private lateinit var dateTimeConverter: DateTimeConverter
    private lateinit var weatherIconResolver: WeatherIconResolver

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
        weatherIconResolver = WeatherIconResolver()

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

                    val bundle = Bundle()
                    bundle.putSerializable("resp",weatherResponse)

                    bundle.putDouble("latitude",location.latitude)
                    bundle.putDouble("longitude",location.longitude)
                    arguments = bundle

                    activity?.runOnUiThread {
                        tv_description.text = weatherResponse.current.weather[0].description
                        tv_temperature.text = temperatureConverter.degConvert(weatherResponse.current.temp)
                        tv_day_info.text = "${result.countryName}, ${result.adminArea},\n${dateTimeConverter.dayInfo()}"

                        var backgroundDrawableName = weatherIconResolver.findPicture(weatherResponse.current.weather[0].icon)
                        iv_description.setBackgroundResource(
                            weatherIconResolver.getLayoutBackgroundDrawableId(backgroundDrawableName, R.drawable::class.java))

                    }


                    hourlyWeatherItemList = ArrayList()
                    weatherResponse.hourly.forEach { hourly ->
                        hourlyWeatherItemList.add(
                                HourlyWeatherItem(
                                        hourly.dt,
                                        hourly.temp,
                                        "$BASE_IMAGE_URI${hourly.weather[0].icon}.png"
                                )
                        )
                    }
                    activity?.runOnUiThread {
                        hourlyWeatherItemList.forEach() {
                            rv_hourly_weather.adapter = HourlyWeatherAdapter(hourlyWeatherItemList)
                        }
                    }
                }
            }
        }
    }


}