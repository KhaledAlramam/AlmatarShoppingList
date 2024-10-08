package com.khaled.almatarshoppinglist.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khaled.almatarshoppinglist.data.repoimp.ShoppingItemRepoImpl
import com.khaled.almatarshoppinglist.domain.ShoppingItem
import com.khaled.almatarshoppinglist.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(private val shoppingItemRepo: ShoppingItemRepoImpl) :
    ViewModel() {
    private val _result = MutableStateFlow<Resource<Boolean>>(Resource.Idle)
    val result: StateFlow<Resource<Boolean>> = _result

    fun insertItem(item: ShoppingItem) {
        viewModelScope.launch {
            _result.value = Resource.Loading
            shoppingItemRepo.insertItem(item)
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

    fun resetResult() {
        _result.value = Resource.Idle
    }

}