package com.mstudio.listapp.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.mstudio.listapp.data.db.entities.ReportItem
import com.mstudio.listapp.data.repositories.ReportRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReportViewModel (
    private val repository: ReportRepository
        ) : ViewModel() {

    fun upsert(item: ReportItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ReportItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}