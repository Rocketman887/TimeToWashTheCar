
package com.example.timetowashthecar.data.api

import com.example.timetowashthecar.data.models.WeatherPart
import com.example.timetowashthecar.data.models.WeatherResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactory {

    private const val QUERY_API_KEY = "df80af6add98f845c1f7a85200492295"
    private const val QUERY_UNITS = "metric"
    private const val QUERY_LANG = "eng"
    private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"

    private val apiKeyInterceptor = Interceptor { chain ->
        val original = chain.request()
        original.url().newBuilder()
            .addQueryParameter("appid", QUERY_API_KEY )
            .build()
            .let {
                chain.proceed(
                    original.newBuilder().url(it).build()
                )
            }
    }

    private val metricInterceptor = Interceptor { chain ->
        val original = chain.request()
        original.url().newBuilder()
            .addQueryParameter("lang", QUERY_LANG)
            .addQueryParameter("units", QUERY_UNITS)
            .build()
            .let {
                chain.proceed(
                    original.newBuilder().url(it).build()
                )
            }
    }

    private val client by lazy {
        OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(LoggingInterceptor())
            .addInterceptor(metricInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val weatherApi:WeatherAPI by lazy{
        retrofit.create(WeatherAPI::class.java)
    }
    suspend fun getWeatherByCoord(lat:Double,lon:Double,exclude:WeatherPart): WeatherResponse {
        return weatherApi.getWeatherByCoord(lat, lon, exclude)
    }

}