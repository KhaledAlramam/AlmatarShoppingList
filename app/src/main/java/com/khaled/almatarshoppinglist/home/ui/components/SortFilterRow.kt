package com.khaled.almatarshoppinglist.home.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SortFilterRow(
    onSortClick: () -> Unit,
    onFilterClick: () -> Unit,modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp), // Add padding
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SortFilterButton(
            onClick = onSortClick,
            text = "Sort",
            icon = Icons.Default.KeyboardArrowDown
        )
        SortFilterButton(
            onClick = onFilterClick,
            text = "Filter",
            icon = Icons.AutoMirrored.Default.List
        )
    }
}
@Composable
private fun SortFilterButton(
    onClick: () -> Unit,
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,modifier = modifier,
        shape = RoundedCornerShape(8.dp), // Rounded corners
        border = BorderStroke(1.dp, Color.LightGray), // Subtle border
        contentPadding = PaddingValues(12.dp) // Add padding
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary // Use primary color for icon
            )
            Text(text = text)
        }
    }
}

@Preview
@Composable
private fun PreviewSortFilterRow() {
    SortFilterRow({}, {})
}