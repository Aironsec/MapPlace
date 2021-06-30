package com.example.maplesson1.view.base

import android.Manifest
import android.content.pm.PackageManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.maplesson1.model.data.AppState
import com.example.maplesson1.view.base.permission.IPermissions
import com.example.maplesson1.viewmodel.BaseViewModel
import com.example.maplesson1.viewmodel.IInteractor
import com.google.android.material.snackbar.Snackbar

abstract class BaseView<T: AppState, I:IInteractor<T>>: AppCompatActivity(), IPermissions {

    abstract val model: BaseViewModel<T>

    val requestPermissionLaunch =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {

            }

        }

    private fun showCurrentLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            layout.showSnackbar(
                R.string.camera_permission_available,
                Snackbar.LENGTH_INDEFINITE,
                R.string.ok
            ) {
                startCamera()
            }
        } else requestCameraPermission()
    }
//    Показать обоснование необходимости разрешений
    private fun requestLocatePermission(){
        if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {

        }
    }
}