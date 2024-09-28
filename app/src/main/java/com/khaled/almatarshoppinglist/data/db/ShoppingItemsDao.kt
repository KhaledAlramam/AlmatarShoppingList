package com.khaled.almatarshoppinglist.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.khaled.almatarshoppinglist.domain.ShoppingItem

@Dao
interface ShoppingItemsDao {

    @Query("SELECT * FROM shoppingitem WHERE is_bought = 1")
    suspend fun getBoughtItems(): List<ShoppingItem>

    @Query("SELECT * FROM shoppingitem WHERE is_bought = 0")
    suspend fun getUnBoughtItems(): List<ShoppingItem>

    @Query("SELECT * FROM shoppingitem")
    suspend fun getAllItems(): List<ShoppingItem>

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ShoppingItem)

    @Update
    suspend fun update(item: ShoppingItem)


}