package com.aerc.kotlinexpert.ui.screens.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.*
import com.aerc.kotlinexpert.data.Filter
import com.aerc.kotlinexpert.data.Note

@Composable
fun TopBar(
    onFilterClick: (Filter) -> Unit
) {
    TopAppBar(
        title = { Text("My Notes") },
        actions = {
            FiltersAction(
                onFilterClick = onFilterClick
            )
        })
}

@Composable
fun FiltersAction(
    onFilterClick: (Filter) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(onClick = {
        expanded = true
    }) {
        Icon(
            imageVector = Icons.Default.FilterList,
            contentDescription = "Filter"
        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(onClick = {
                expanded = false
                onFilterClick(Filter.All)
            }) {
                Text("All")
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onFilterClick(Filter.ByType(Note.Type.TEXT))
            }
            ) {
                Text("Text")
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onFilterClick(Filter.ByType(Note.Type.AUDIO))
            }) {
                Text("Audio")
            }
        }
    }
}
