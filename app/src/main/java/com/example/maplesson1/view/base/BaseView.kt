package com.example.maplesson1.view.base

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.maplesson1.model.data.AppState
import com.example.maplesson1.viewmodel.BaseViewModel
import com.example.maplesson1.viewmodel.IInteractor

abstract class BaseView<T: AppState, I:IInteractor<T>>: AppCompatActivity() {

    abstract val model: BaseViewModel<T>

    abstract fun renderData(appState: T)

    fun navigationTo(cls: Class<*>) {
        Intent(this, cls).also {
            startActivity(it)
        }
    }
}