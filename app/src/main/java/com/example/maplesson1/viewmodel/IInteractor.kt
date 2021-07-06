package com.example.maplesson1.viewmodel

interface IInteractor<T> {
    suspend fun getListLatLon(): T

}