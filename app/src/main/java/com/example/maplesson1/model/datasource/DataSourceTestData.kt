package com.example.maplesson1.model.datasource

import com.example.maplesson1.model.data.LatLon

class DataSourceTestData: IDataSource<List<LatLon>> {
    override suspend fun getListLatLon(): List<LatLon> {
        return listOf(
            LatLon(55.117092, 36.597050, "Обнинск"),
            LatLon(55.178737, 36.659834, "Балабаново"),
            LatLon(55.099778, 36.602674, "Обнинск, Ленина д.85")
        )
    }
}