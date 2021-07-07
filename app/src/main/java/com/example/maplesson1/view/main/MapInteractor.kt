package com.example.maplesson1.view.main

import com.example.maplesson1.model.data.AppState
import com.example.maplesson1.model.data.LatLon
import com.example.maplesson1.model.repository.IRepository
import com.example.maplesson1.viewmodel.IInteractor

class MapInteractor(private val repository: IRepository<List<LatLon>>): IInteractor<AppState> {

    override suspend fun getListLatLon(): AppState = AppState.Success(repository.getListLatLon())
}