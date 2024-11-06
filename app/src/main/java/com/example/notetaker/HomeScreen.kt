package com.example.notetaker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HomeScreen(
    notesViewModel: NotesViewModel = viewModel(),
    navRoute: () -> Unit
) {
    val notesUIState by notesViewModel.uiState.collectAsState()
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "NotePal"
            )
            Button(
                onClick = navRoute
            ) {
                Text(
                    "Add Note"
                )
            }
        }
       notesUIState.notes.forEach{NoteCard(it.title)}
    }
}

@Composable
fun NoteCard(
    title: String
) {
    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),

        ) {
    Text(title)
    }
}