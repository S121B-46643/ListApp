package com.mstudio.listapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mstudio.listapp.data.db.entities.ReportItem

@Dao
interface ReportDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ReportItem)

    @Delete
    suspend fun delete(item: ReportItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShopingItems(): LiveData<List<ReportItem>>
}