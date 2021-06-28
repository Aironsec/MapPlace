package com.example.maplesson1.ui

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import com.example.maplesson1.R
import com.example.maplesson1.utils.Constants.REQUEST_CODE_LOCATION_PERMISSION
import com.example.maplesson1.utils.Permissions
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

}