package com.example.maplesson1.view.base.permission

import android.location.Location
import android.location.LocationManager

interface IPermissions{
    fun getLocationWithPermission(mLocManager: LocationManager): Location?
}