package com.example.maplesson1.utils.uselocation

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class UseLocation (private val context: Context): IUseLocation, AppCompatActivity() {

    private lateinit var mLocManager: LocationManager

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                getLocationWithPermission()

            } else {
                // Permission request was denied.
                layout.showSnackbar(
                    R.string.camera_permission_denied,
                    Snackbar.LENGTH_SHORT,
                    R.string.ok)
            }
        }

    override fun getLocationWithPermission(): Location? {
        val permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        permissions.forEach { permission ->
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED)
                return requestLocationPermission()
        }
        return mLocManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)
    }

    private fun requestLocationPermission(): Location? {
        if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
            layout.showSnackbar(
                R.string.camera_access_required,
                Snackbar.LENGTH_INDEFINITE,
                R.string.ok
            ) {
                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        } else {
            // You can directly ask for the permission.
            layout.showSnackbar(
                R.string.camera_permission_not_available,
                Snackbar.LENGTH_LONG,
                R.string.ok
            ) {
                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

}