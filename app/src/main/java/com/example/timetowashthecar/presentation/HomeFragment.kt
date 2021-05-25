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
import com.example.timetowashthecar.data.dto.WeatherPart
import com.example.timetowashthecar.domain.*
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.bt_location
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
    private lateinit var temperatureConverter: TemperatureConverter
    private lateinit var dateTimeConverter: DateTimeConverter
    private lateinit var weatherIconResolver: WeatherIconResolver
    private lateinit var pressureConverter: PressureConverter
    private lateinit var humidityConverter: HumidityConverter
    private lateinit var windSpeedConverter: WindSpeedConverter
    private lateinit var mainImageViewResolver: MainImageViewResolver


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
        pressureConverter = PressureConverter()
        humidityConverter = HumidityConverter()
        windSpeedConverter = WindSpeedConverter()
        mainImageViewResolver = MainImageViewResolver()

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
                Log.d("hi", "error")
                return
            }
            mFusedLocationClient.lastLocation.addOnSuccessListener(activity) { location: Location ->
                launch {
                    Log.d(
                        "Coords",
                        "latitude: ${location.latitude.toFloat()}, longitude:${location.longitude.toFloat()}"
                    )
                    val weatherResponse = ApiFactory.getWeatherByCoord(
                        location.latitude,
                        location.longitude,
                        WeatherPart.minutely
                    )

                    val geoCoder = Geocoder(context, Locale.getDefault())
                    val addresses: List<Address> =
                        geoCoder.getFromLocation(location.latitude, location.longitude, 1)
                    val result = addresses[0]

                    activity?.runOnUiThread {
                        tv_description.text = weatherResponse.current.weather[0].description
                        tv_day_temperature.text =
                            temperatureConverter.degConvert(weatherResponse.daily[0].temp.day)
                        tv_day_info.text =
                            "${result.countryName}, ${result.adminArea},\n${dateTimeConverter.dayInfo()}"

                        tv_feels_like_temperature.text =
                            temperatureConverter.degConvert(weatherResponse.daily[0].temp.night)
                        tv_wp2_pressure.text =
                            pressureConverter.convert(weatherResponse.current.pressure)
                        tv_wp2_humidity.text =
                            humidityConverter.convert(weatherResponse.current.humidity)
                        tv_wp2_wind_speed.text =
                            windSpeedConverter.convert(weatherResponse.current.wind_speed)

                        var backgroundDrawableName =
                            weatherIconResolver.findPicture(weatherResponse.current.weather[0].icon)
                        iv_description.setBackgroundResource(backgroundDrawableName)

                        iv_car.setImageResource(mainImageViewResolver.findPicture(weatherResponse.current.weather[0].main))

                        listDTO = ArrayList()
                        weatherResponse.daily.forEach { daily ->
                            listDTO.add(
                                WeeklyAnalyzeDTO(
                                    temperatureConverter.degConvertToInt(daily.temp.day),
                                    dateTimeConverter.convert(daily.dt),
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