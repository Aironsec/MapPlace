package com.example.maplesson1.view.main

import android.location.LocationManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.maplesson1.MapHolder
import com.example.maplesson1.MyPlacesActivity
import com.example.maplesson1.R
import com.example.maplesson1.databinding.ActivityMapsBinding
import com.example.maplesson1.model.data.AppState
import com.example.maplesson1.view.base.BaseView
import com.example.maplesson1.viewmodel.BaseViewModel
import com.google.android.gms.maps.SupportMapFragment

class MapActivity: BaseView<AppState, MapInteractor>() {
    private lateinit var binding: ActivityMapsBinding
    private lateinit var mLocManager: LocationManager

    override lateinit var model: BaseViewModel<AppState>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mLocManager = getSystemService(LOCATION_SERVICE) as LocationManager

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(MapHolder())
        initViewModel()
    }

    private fun initViewModel() {
        val
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_map_location -> {

//                   getLocationWithPermission(mLocManager)

            }
            R.id.menu_map_myplaces -> {
                navigationTo(MyPlacesActivity::class.java)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun renderData(appState: AppState) {
        TODO("Not yet implemented")
    }

}