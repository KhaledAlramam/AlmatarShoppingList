package com.khaled.almatarshoppinglist.util

sealed class Resource<out T>(data: T?) {
    object Loading : Resource<Nothing>(null)
    object Idle : Resource<Nothing>(null)
    data class Success<out T>(val data: T) : Resource<T>(data)
}