package com.example.maplesson1.di

import com.example.maplesson1.model.datasource.DataSourceTestData
import com.example.maplesson1.model.repository.RepositoryImpl
import com.example.maplesson1.view.main.MapInteractor
import com.example.maplesson1.view.main.MapViewModel
import org.koin.dsl.module

val repository = module {
    single { RepositoryImpl(DataSourceTestData()) }
}

val mapScreen = module {
    factory { MapInteractor(get()) }
    factory { MapViewModel(get()) }
}