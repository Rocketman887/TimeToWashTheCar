package com.example.timetowashthecar.presentation

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timetowashthecar.R
import com.example.timetowashthecar.data.api.ApiFactory
import com.example.timetowashthecar.data.repository.Repository
import com.example.timetowashthecar.domain.NearCityAdapter
import com.example.timetowashthecar.domain.NearCityItem
import com.example.timetowashthecar.domain.PermissionHelper
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import kotlin.coroutines.CoroutineContext

class SearchFragment() : Fragment(), CoroutineScope {
    override val coroutineContext: CoroutineContext = Dispatchers.IO

    private val api = ApiFactory.weatherApi

    private lateinit var repository: Repository

    private lateinit var permissionHelper: PermissionHelper

    private lateinit var searchView: SearchView
    private lateinit var searchManager: SearchManager

    private lateinit var recyclerView: RecyclerView
    private lateinit var city: String
    private lateinit var listDTO:ArrayList<NearCityItem>

    private var cord_latitude:Double? = null
    private var cord_longitude:Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        permissionHelper = PermissionHelper()

        recyclerView = view?.findViewById(R.id.cities_list)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
        }
        getWeatherListAfterGrantedLocation()

            searchView = view.findViewById(R.id.sv_city)
            searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager

            searchView.setSearchableInfo(
                searchManager.getSearchableInfo(activity?.componentName)
            )
            searchView.isIconified = false
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                @SuppressLint("ShowToast")
                override fun onQueryTextSubmit(query: String?): Boolean {
                    city = searchView.query.toString()
                    lifecycleScope.launch {
                        try {
                            api.getWeatherByName(city).let {
                            }
                        } catch (e: HttpException) {
                            Snackbar.make(
                                view,
                                "This city does not exist",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }

            }


            )
        }

    private fun getWeatherListAfterGrantedLocation(){
        listDTO = ArrayList<NearCityItem>()
        activity?.let { activity ->
            val mFusedLocationClient =
                LocationServices.getFusedLocationProviderClient(activity)
            if (ActivityCompat.checkSelfPermission(
                    activity,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
                != PackageManager.PERMISSION_GRANTED && ActivityCompat
                    .checkSelfPermission(activity, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
            ) {
                Log.d("hi", "error")
                return
            }
            mFusedLocationClient.lastLocation.addOnSuccessListener { location: Location ->
                cord_latitude = location.latitude
                cord_longitude = location.longitude
                Log.d("Coords", "latitude: ${location.latitude}, longitude:${location.longitude}")
                cord_latitude?.let { lt ->
                    cord_longitude?.let { ln ->
                        launch {
                            val str =
                                ApiFactory.getWeatherList(lt, ln)
                            listDTO = ArrayList()
                            str.forEach { weather ->
                                listDTO.add(
                                    NearCityItem(
                                        weather.id,
                                        weather.name,
                                        weather.main.temp.toInt(),
                                        weather.coord.lat,
                                        weather.coord.lon
                                    )
                                )
                            }
                            activity?.runOnUiThread {
                                listDTO.forEach {
                                    recyclerView.adapter = NearCityAdapter(listDTO)
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }
}
