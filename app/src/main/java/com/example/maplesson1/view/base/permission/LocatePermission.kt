package com.example.maplesson1.view.base.permission

import android.content.Context
import com.example.maplesson1.utils.Permissions

class LocatePermission(private val context: Context): IPermissions {

    override fun requestPermission(getLoc: () -> Unit) {
        if (Permissions.hasLocationPermission(context)){
            getLoc.invoke()
        }
    }
}