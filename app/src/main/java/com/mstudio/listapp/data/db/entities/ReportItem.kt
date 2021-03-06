package com.mstudio.listapp.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ReportItem(
    @ColumnInfo(name = "Item_name")
    var name: String,
    @ColumnInfo(name = "Item_amount")
    var CodeType: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
//Coment