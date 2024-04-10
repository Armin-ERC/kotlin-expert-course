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

    @Composable
    infix fun Filter.toMenuItem(label : String){
        DropdownMenuItem(onClick = {
            expanded = false
            onFilterClick(this)
        }) {
            Text(label)
        }
    }

    IconButton(onClick = {
        expanded = true
    }) {
        Icon(
            imageVector = Icons.Default.FilterList,
            contentDescription = "Filter"
        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            Filter.All toMenuItem "All"
            Filter.ByType(Note.Type.TEXT) toMenuItem "Text"
            Filter.ByType(Note.Type.AUDIO) toMenuItem "Audio"
        }
    }
}
