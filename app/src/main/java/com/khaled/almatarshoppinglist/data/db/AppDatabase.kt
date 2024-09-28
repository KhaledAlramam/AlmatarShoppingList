package com.khaled.almatarshoppinglist.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khaled.almatarshoppinglist.domain.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun shoppingItemsDao(): ShoppingItemsDao
}