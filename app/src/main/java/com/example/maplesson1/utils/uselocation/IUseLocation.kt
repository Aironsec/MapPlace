package com.example.maplesson1.utils.uselocation

import android.location.Location

interface IUseLocation {
    fun getLocationWithPermission(): Location?
}