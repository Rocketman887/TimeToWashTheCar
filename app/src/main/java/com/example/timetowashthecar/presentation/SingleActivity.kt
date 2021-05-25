package com.example.timetowashthecar.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.timetowashthecar.R
import com.example.timetowashthecar.domain.helper.PermissionHelper
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*

class SingleActivity : AppCompatActivity() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var searchFragment: SearchFragment
    private lateinit var permissionHelper: PermissionHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single)

        permissionHelper = PermissionHelper()
    }

    override fun onStart() {
        super.onStart()
        permissionHelper.check(this)
    }
    private val navController by lazy {
        (supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment).navController
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()

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