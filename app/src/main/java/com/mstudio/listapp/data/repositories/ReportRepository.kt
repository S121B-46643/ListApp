package com.mstudio.listapp.data.repositories

import com.mstudio.listapp.data.db.ReportDatabase
import com.mstudio.listapp.data.db.entities.ReportItem

class ReportRepository(
    private val db: ReportDatabase
    ){
    suspend fun  upsert(item: ReportItem) = db.getShoppingDao().upsert(item)

    suspend fun  delete(item: ReportItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShopingItems()
}