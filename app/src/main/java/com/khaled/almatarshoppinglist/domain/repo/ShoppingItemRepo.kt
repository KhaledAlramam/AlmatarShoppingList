package com.khaled.almatarshoppinglist.domain.repo

import com.khaled.almatarshoppinglist.domain.ShoppingItem

interface ShoppingItemRepo {

    suspend fun getAllItems(): List<ShoppingItem>

    suspend fun getBoughtItems(isAsc: Boolean): List<ShoppingItem>

    suspend fun getUnBoughtItems(isAsc: Boolean): List<ShoppingItem>

    suspend fun insertItem(item: ShoppingItem)

    suspend fun updateItem(item: ShoppingItem)

    suspend fun deleteItem(item: ShoppingItem)

}