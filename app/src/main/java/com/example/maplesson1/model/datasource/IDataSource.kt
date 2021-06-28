package com.example.maplesson1.model.datasource

interface IDataSource<T> {
    suspend fun getListLatLon(): T
}