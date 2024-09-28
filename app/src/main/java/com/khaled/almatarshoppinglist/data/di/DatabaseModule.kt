package com.khaled.almatarshoppinglist.data.di

import android.content.Context
import androidx.room.Room
import com.khaled.almatarshoppinglist.data.db.AppDatabase
import com.khaled.almatarshoppinglist.data.db.ShoppingItemsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "room_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(appDatabase: AppDatabase): ShoppingItemsDao {
        return appDatabase.shoppingItemsDao()
    }

}