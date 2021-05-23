package com.mstudio.listapp.ui.shoppinglist

import com.mstudio.listapp.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonCLicked(item: ShoppingItem)
}