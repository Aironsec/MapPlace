package com.example.maplesson1.di

import com.example.maplesson1.model.data.AppState
import com.example.maplesson1.model.data.LatLon
import com.example.maplesson1.model.datasource.DataSourceTestData
import com.example.maplesson1.model.repository.IRepository
import com.example.maplesson1.model.repository.RepositoryImpl
import com.example.maplesson1.view.main.MapInteractor
import com.example.maplesson1.view.main.MapViewModel
import com.example.maplesson1.viewmodel.IInteractor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repository = module {
    single<IRepository<List<LatLon>>> { RepositoryImpl(DataSourceTestData()) }
}

val mapScreen = module {
    factory<IInteractor<AppState>> { MapInteractor(get()) }
    viewModel { MapViewModel(get()) }
}