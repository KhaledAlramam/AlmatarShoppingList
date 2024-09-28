package com.khaled.almatarshoppinglist.home.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.khaled.almatarshoppinglist.util.FilterEnum

@Composable
fun FilterComposable(
    currentFilter: FilterEnum,
    onFilterChange: (FilterEnum) -> Unit
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        FilterChip(
            selected = currentFilter == FilterEnum.BOUGHT,
            onClick = { onFilterChange(FilterEnum.BOUGHT) },
            label ={ Text("Bought") }
        )
        Spacer(modifier = Modifier.width(8.dp))
        FilterChip(
            selected = currentFilter == FilterEnum.UNBOUGHT,
            onClick = { onFilterChange(FilterEnum.UNBOUGHT) },
            label = { Text("Unbought") }
        )
    }
}