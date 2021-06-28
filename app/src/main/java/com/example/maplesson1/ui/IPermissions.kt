package com.example.maplesson1.ui

import pub.devrel.easypermissions.EasyPermissions

interface IPermissions: EasyPermissions.PermissionCallbacks {
    fun requestPermission()
    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {}
}