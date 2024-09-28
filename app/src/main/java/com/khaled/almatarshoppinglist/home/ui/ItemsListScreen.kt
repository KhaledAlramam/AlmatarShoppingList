package com.khaled.almatarshoppinglist.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.khaled.almatarshoppinglist.addedititem.AddEditItemScreen
import com.khaled.almatarshoppinglist.domain.ShoppingItem
import com.khaled.almatarshoppinglist.home.ui.components.AddItemFab
import com.khaled.almatarshoppinglist.home.ui.components.FilterComposable
import com.khaled.almatarshoppinglist.home.ui.components.ShoppingListItemComp
import com.khaled.almatarshoppinglist.home.ui.components.SortFilterRow
import com.khaled.almatarshoppinglist.presenter.viewmodel.ItemListScreenViewModel
import com.khaled.almatarshoppinglist.util.FilterEnum
import com.khaled.almatarshoppinglist.util.Resource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsListScreen(modifier: Modifier = Modifier) {
    val viewModel: ItemListScreenViewModel = viewModel()
    val items by viewModel.items.collectAsState()
    val resultState by viewModel.result.collectAsState()
    val addEditBottomSheetState = rememberModalBottomSheetState()
    var showAddEditBottomSheet by remember { mutableStateOf(false) }
    var selectedItem: ShoppingItem? by remember {
        mutableStateOf(null)
    }
    var currentFilter by remember { mutableStateOf(FilterEnum.UNBOUGHT) }
    LaunchedEffect(key1 = currentFilter) {
        viewModel.getItems(currentFilter.value)
    }
    LaunchedEffect(key1 =resultState ) {
        if (resultState is Resource.Success){
            viewModel.getItems(currentFilter.value)
        }
    }
    Scaffold(floatingActionButton = {
        AddItemFab(onFabClicked = {
            selectedItem = null
            showAddEditBottomSheet = true
        })
    }) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            FilterComposable(currentFilter = currentFilter) { newFilter ->
                currentFilter = newFilter
            }

            LazyColumn {
                items(items.size) {
                    val item = items[it]
                    ShoppingListItemComp(item = item,
                        onDeleteClick = { viewModel.deleteItem(item) },
                        onEditClick = {
                            selectedItem = item
                            showAddEditBottomSheet = true
                        })
                }
            }
        }
        if (showAddEditBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    selectedItem = null
                    showAddEditBottomSheet = false
                },
                sheetState = addEditBottomSheetState,
                containerColor = MaterialTheme.colorScheme.background
            ) {
                AddEditItemScreen(
                    onCancel = {
                        selectedItem = null
                        showAddEditBottomSheet = false
                    },
                    onSave = {
                        selectedItem = null
                        showAddEditBottomSheet = false
                        viewModel.getItems(currentFilter.value)
                    },
                    modifier = Modifier.padding(8.dp),
                    item = selectedItem
                )
            }
        }
    }
}