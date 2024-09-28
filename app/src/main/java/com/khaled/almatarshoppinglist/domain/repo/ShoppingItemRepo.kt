package com.khaled.almatarshoppinglist.domain.repo

import com.khaled.almatarshoppinglist.domain.ShoppingItem

interface ShoppingItemRepo {

    suspend fun getAllItems(): List<ShoppingItem>

    suspend fun getBoughtItems(): List<ShoppingItem>

    suspend fun getUnBoughtItems(): List<ShoppingItem>

    suspend fun insertItem(item: ShoppingItem)

    suspend fun updateItem(item: ShoppingItem)

    suspend fun deleteItem(item: ShoppingItem)

}