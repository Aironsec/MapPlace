package com.example.maplesson1.view.main

import androidx.lifecycle.LiveData
import com.example.maplesson1.model.data.AppState
import com.example.maplesson1.viewmodel.BaseViewModel

class MapViewModel(private val interactor: MapInteractor): BaseViewModel<AppState>() {

    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData

    fun subscribe(): LiveData<AppState> = liveDataForViewToObserve

    override fun handlerError(error: Throwable) = _mutableLiveData.postValue(AppState.Error(error))

    override suspend fun getListLatLon() {
        _mutableLiveData.postValue(interactor.getListLatLon())
    }

    override fun onCleared() {
        _mutableLiveData.value = AppState.Success(null)
        super.onCleared()
    }
}