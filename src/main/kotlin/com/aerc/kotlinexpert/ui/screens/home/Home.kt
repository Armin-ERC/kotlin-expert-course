package com.aerc.kotlinexpert.ui.screens.home


import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
@Preview
fun Home(
    onCreateClicked : () -> Unit
): Unit = with(HomeState) {

    val state by state.collectAsState()

    LaunchedEffect(true) {
        loadNotes(this)
    }

    MaterialTheme {
        Scaffold(
            topBar = { TopBar( onFilterClick = ::onFilterClick) },
            floatingActionButton = {
                FloatingActionButton(onClick = onCreateClicked){
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add note")
                }
            }
        ) { padding ->
            Box(
                modifier = Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center
            ) {
                if (state.loading) {
                    CircularProgressIndicator()
                }
                state.filteredNotes?.let {
                    NoteList(it)
                }
            }
        }
    }

}

