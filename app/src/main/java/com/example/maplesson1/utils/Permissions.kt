package com.example.maplesson1.utils

import android.Manifest
import android.content.Context
import pub.devrel.easypermissions.EasyPermissions

object Permissions {
    fun hasLocationPermission(context: Context) =
        EasyPermissions.hasPermissions(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
}