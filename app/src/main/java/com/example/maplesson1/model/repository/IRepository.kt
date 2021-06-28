package com.example.maplesson1.model.repository

interface IRepository<T> {
    suspend fun getListLatLon(): T
}