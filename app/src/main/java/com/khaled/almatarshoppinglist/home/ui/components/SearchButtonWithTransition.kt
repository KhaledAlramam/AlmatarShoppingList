package com.khaled.almatarshoppinglist.home.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchButtonWithTransition(
    onSearchValueChanged: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }
    val transition = updateTransition(targetState = isExpanded, label = "SearchTransition")

    val searchFieldWidth by transition.animateDp(
        transitionSpec = {
            if (targetState) {
                tween(durationMillis = 300, easing = FastOutSlowInEasing)
            } else {
                tween(durationMillis = 300, easing = FastOutSlowInEasing)
            }
        },
        label = "SearchFieldWidthTransition"
    ) {
        if (it) 240.dp else 0.dp
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
                onSearchValueChanged(searchText)
            },
            placeholder = { Text("Search...") },
            singleLine = true,
            modifier = Modifier
                .width(searchFieldWidth)
        )

        Spacer(modifier = Modifier.width(8.dp))

        IconButton(onClick = {
            isExpanded = !isExpanded
        }) {
            Icon(
                imageVector = if (isExpanded) Icons.Filled.Close else Icons.Filled.Search,
                contentDescription = if (isExpanded) "Close" else "Search"
            )
        }
    }
}