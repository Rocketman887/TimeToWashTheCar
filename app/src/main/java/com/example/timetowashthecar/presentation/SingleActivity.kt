package com.example.timetowashthecar.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.timetowashthecar.R
import com.example.timetowashthecar.domain.PermissionHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*

class SingleActivity : AppCompatActivity() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var carWashesFragment: CarWashesFragment
    private lateinit var settingsFragment: SettingsFragment

    private lateinit var bottomNavigation: BottomNavigationView

    private lateinit var permissionHelper: PermissionHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        homeFragment = HomeFragment()
        carWashesFragment = CarWashesFragment()
        settingsFragment = SettingsFragment()
        bottomNavigation = findViewById(R.id.bottom_nav)

        permissionHelper = PermissionHelper()

        swapFragments(homeFragment)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> swapFragments(homeFragment)
                R.id.car_washes -> swapFragments(carWashesFragment)
                R.id.settings -> swapFragments(settingsFragment)
            }
            true
        }

    }

    override fun onStart() {
        super.onStart()

        permissionHelper.check(this)
    }
    private fun swapFragments(fragment:Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (!permissionHelper.handle(requestCode, permissions, grantResults)) {
            permissionHelper.check(this)
            Snackbar.make(cl_home_fragment,
                "no permissions dude",
                Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(cl_home_fragment,
                "nice dude",
                Snackbar.LENGTH_SHORT).show()
        }
    }
}