package com.example.maplesson1.view.base

import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.maplesson1.model.data.AppState
import com.example.maplesson1.viewmodel.BaseViewModel
import com.example.maplesson1.viewmodel.IInteractor

abstract class BaseView<T: AppState, I:IInteractor<T>>: AppCompatActivity() {
    abstract val model: BaseViewModel<T>
    val requestPermissionLaunch =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {

            }

        }
}