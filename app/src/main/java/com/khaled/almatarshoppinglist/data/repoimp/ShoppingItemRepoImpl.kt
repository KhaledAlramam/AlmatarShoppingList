package com.khaled.almatarshoppinglist.data.repoimp

import com.khaled.almatarshoppinglist.data.db.ShoppingItemsDao
import com.khaled.almatarshoppinglist.domain.ShoppingItem
import com.khaled.almatarshoppinglist.domain.repo.ShoppingItemRepo
import javax.inject.Inject

class ShoppingItemRepoImpl @Inject constructor(private val shoppingItemsDao: ShoppingItemsDao) :
    ShoppingItemRepo {

    override suspend fun getAllItems(): List<ShoppingItem> {
        return shoppingItemsDao.getAllItems()
    }

    override suspend fun getBoughtItems(isAsc: Boolean, query: String?): List<ShoppingItem> {
        return shoppingItemsDao.getBoughtItems(isAsc, query)
    }

    override suspend fun getUnBoughtItems(isAsc: Boolean, query: String?): List<ShoppingItem> {
        return shoppingItemsDao.getUnBoughtItems(isAsc, query)
    }

    override suspend fun insertItem(item: ShoppingItem) {
        return shoppingItemsDao.insert(item)
    }

    override suspend fun updateItem(item: ShoppingItem) {
        return shoppingItemsDao.update(item)
    }

    override suspend fun deleteItem(item: ShoppingItem) {
        return shoppingItemsDao.delete(item)
    }
}