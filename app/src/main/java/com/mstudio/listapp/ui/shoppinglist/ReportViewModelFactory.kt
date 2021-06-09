package com.mstudio.listapp.ui.shoppinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mstudio.listapp.data.repositories.ReportRepository

class ReportViewModelFactory(
    private val repository: ReportRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ReportViewModel(repository) as T
    }
}