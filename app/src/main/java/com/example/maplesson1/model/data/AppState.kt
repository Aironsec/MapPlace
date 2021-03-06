package com.example.maplesson1.model.data

sealed class AppState{
    data class Success(val data: List<LatLon>?): AppState()
    data class ResultPermission(val result: Boolean):AppState()
    data class Error(val error: Throwable): AppState()
    data class Loading(val progress: Int?): AppState()
}
