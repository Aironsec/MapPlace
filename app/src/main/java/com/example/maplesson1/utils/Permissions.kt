package com.example.maplesson1.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat

object Permissions {
    fun hasLocationPermission(context: Context?): Boolean {
        val requiredPermissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        checkNotNull(context)
        requiredPermissions.forEach { permission ->
            if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED)
                return false
        }
        return true
    }

}