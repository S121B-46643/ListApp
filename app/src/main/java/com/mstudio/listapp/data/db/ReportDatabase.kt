package com.mstudio.listapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mstudio.listapp.data.db.entities.ReportItem


@Database(
    entities = [ReportItem::class],
    version = 1)
abstract class ReportDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ReportDao

    companion object {
        @Volatile
        private var instance: ReportDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it}
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ReportDatabase::class.java, "ShopingDB.db").build()
    }
}