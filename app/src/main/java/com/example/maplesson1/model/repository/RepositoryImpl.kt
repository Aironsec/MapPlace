package com.example.maplesson1.model.repository

import com.example.maplesson1.model.data.LatLon
import com.example.maplesson1.model.datasource.IDataSource

class RepositoryImpl(private val dataSource: IDataSource<List<LatLon>>): IRepository<List<LatLon>> {

    override suspend fun getListLatLon(): List<LatLon> = dataSource.getListLatLon()
}