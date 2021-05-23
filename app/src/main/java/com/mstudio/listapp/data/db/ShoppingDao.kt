package com.mstudio.listapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mstudio.listapp.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShopingItems(): LiveData<List<ShoppingItem>>
}