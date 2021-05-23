package com.mstudio.listapp.data.repositories

import com.mstudio.listapp.data.db.ShoppingDatabase
import com.mstudio.listapp.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
    ){
    suspend fun  upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun  delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShopingItems()
}