package com.example.maplesson1

import android.content.Intent
import android.location.LocationManager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.maplesson1.databinding.ActivityMapsBinding
import com.example.maplesson1.ui.BaseMapsActivity
import com.google.android.gms.maps.SupportMapFragment

class MapsActivity: BaseMapsActivity() {
    private lateinit var binding: ActivityMapsBinding
    private lateinit var mLocManager: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestPermission()
        mLocManager = getSystemService(LOCATION_SERVICE) as LocationManager

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(MapHolder())
    }

    private fun navigationTo(cls: Class<*>) {
        Intent(this, cls).also {
            startActivity(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_map_location -> {

//                   val loc = mLocManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)

            }
            R.id.menu_map_myplaces -> {
                navigationTo(MyPlacesActivity::class.java)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}