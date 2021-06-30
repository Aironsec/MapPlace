package com.example.maplesson1.view.base.permission

import pub.devrel.easypermissions.EasyPermissions

interface IPermissions{
    fun requestPermission(getLoc: () -> Unit)
}