package com.khaled.almatarshoppinglist.data.di

import com.khaled.almatarshoppinglist.data.repoimp.ShoppingItemRepoImpl
import com.khaled.almatarshoppinglist.domain.repo.ShoppingItemRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun bindShoppingItemRepo(impl: ShoppingItemRepoImpl): ShoppingItemRepo

}