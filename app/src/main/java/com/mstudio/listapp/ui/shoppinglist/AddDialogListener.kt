package com.mstudio.listapp.ui.shoppinglist

import com.mstudio.listapp.data.db.entities.ReportItem

interface AddDialogListener {
    fun onAddButtonCLicked(item: ReportItem)
}