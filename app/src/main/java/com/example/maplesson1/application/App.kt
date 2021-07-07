package com.example.maplesson1.application

import android.app.Application
import com.example.maplesson1.di.repository
import com.example.maplesson1.di.mapScreen
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            printLogger()
            modules(
                repository,
                mapScreen
            )
        }
    }
}