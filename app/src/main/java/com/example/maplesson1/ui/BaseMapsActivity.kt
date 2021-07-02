package com.example.maplesson1.ui

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.maplesson1.R
import com.example.maplesson1.utils.Constants.REQUEST_CODE_LOCATION_PERMISSION
import com.example.maplesson1.utils.Permissions
import com.example.maplesson1.view.base.permission.IPermissions
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

open class BaseMapsActivity : AppCompatActivity(), IPermissions {

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        } else {
            requestPermission()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun requestPermission() {
        if (Permissions.hasLocationPermission(this)) {
            return
        } else {
            EasyPermissions.requestPermissions(
                this,
                getString(R.string.request_permission_rationale),
                REQUEST_CODE_LOCATION_PERMISSION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
    }

    override fun getLocationWithPermission(mLocManager: LocationManager): Location? {
        val permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
        permissions.forEach { permission ->
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED)
                return null
        }
        return mLocManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER)
    }

}