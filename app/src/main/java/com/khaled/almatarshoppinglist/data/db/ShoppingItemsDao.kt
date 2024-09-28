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

    @Query("SELECT * FROM shoppingitem WHERE is_bought = 1 " +
            "AND (CASE WHEN :query IS NOT NULL THEN name LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%' ELSE 1 END) " +
            "ORDER BY CASE WHEN :isAsc = 1 THEN name END ASC, CASE WHEN :isAsc = 0 THEN name END DESC")
    suspend fun getBoughtItems(isAsc: Boolean, query: String?=null): List<ShoppingItem>

    @Query("SELECT * FROM shoppingitem WHERE is_bought = 0 " +
            "AND (CASE WHEN :query IS NOT NULL THEN name LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%' ELSE 1 END) " +
            "ORDER BY CASE WHEN :isAsc = 1 THEN name END ASC, CASE WHEN :isAsc = 0 THEN name END DESC")
    suspend fun getUnBoughtItems(isAsc: Boolean, query: String?=null): List<ShoppingItem>

    @Query("SELECT * FROM shoppingitem")
    suspend fun getAllItems(): List<ShoppingItem>

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ShoppingItem)

    @Update
    suspend fun update(item: ShoppingItem)


}