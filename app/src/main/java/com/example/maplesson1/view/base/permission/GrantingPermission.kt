package com.example.maplesson1.view.base.permission

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.content.ContextCompat

class GrantingLocation(private val context: Context): ILocation {
    private lateinit var mLocManager: LocationManager

    override fun getLocationWithPermission(): Location? {
        val permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        permissions.forEach { permission ->
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED)
                return null
        }
        return mLocManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)
    }
}