package com.khaled.almatarshoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.khaled.almatarshoppinglist.home.ui.ItemsListScreen
import com.khaled.almatarshoppinglist.ui.theme.AlmatarShoppingListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlmatarShoppingListTheme {
                ItemsListScreen()
            }
        }
    }
}