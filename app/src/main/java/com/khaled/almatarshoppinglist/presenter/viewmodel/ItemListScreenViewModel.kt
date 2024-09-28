package com.khaled.almatarshoppinglist.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khaled.almatarshoppinglist.domain.ShoppingItem
import com.khaled.almatarshoppinglist.domain.repo.ShoppingItemRepo
import com.khaled.almatarshoppinglist.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemListScreenViewModel @Inject constructor(private val shoppingItemRepo: ShoppingItemRepo) :
    ViewModel() {
    private val _items = MutableStateFlow<List<ShoppingItem>>(emptyList())
    val items: StateFlow<List<ShoppingItem>> = _items


    private val _result = MutableStateFlow<Resource<Boolean>>(Resource.Idle)
    val result: StateFlow<Resource<Boolean>> = _result

    fun getItems(isBought: Boolean, isAsc: Boolean, query: String? = null) {
        viewModelScope.launch {
            if (isBought) _items.value = shoppingItemRepo.getBoughtItems(isAsc,query)
            else _items.value = shoppingItemRepo.getUnBoughtItems(isAsc, query)
        }
    }


    fun deleteItem(item: ShoppingItem) {
        viewModelScope.launch {
            _result.value = Resource.Loading
            shoppingItemRepo.deleteItem(item)
            _result.value = Resource.Success(true)
        }
    }

    fun updateItem(item: ShoppingItem) {
        viewModelScope.launch {
            _result.value = Resource.Loading
            shoppingItemRepo.updateItem(item)
            _result.value = Resource.Success(true)
        }
    }
}