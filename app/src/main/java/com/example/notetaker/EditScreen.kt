package com.example.notetaker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.mutableStateOf




@Composable
fun EditScreen(
    notesViewModel: NotesViewModel = viewModel(),
    navRoute: () -> Unit
) {
    val notesUIState by notesViewModel.uiState.collectAsState()
    val titleValue = rememberSaveable { mutableStateOf("") }
    val contentValue = rememberSaveable { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = navRoute

            ) {
                Text(
                    "Back"
                )
            }

            Button(
                onClick = { }
            ) {
                Text(
                    "Delete"
                )
            }
        }
        Spacer(modifier = Modifier.padding(bottom = 60.dp))
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                onValueChange = { titleValue.value = it },
                value = titleValue.value,
                singleLine = true,
                label = { Text("Enter a title") }
            )
            Spacer(modifier = Modifier.padding(bottom = 30.dp))
            OutlinedTextField(
                modifier = Modifier.height(300.dp),
                onValueChange = { contentValue.value = it },
                value = contentValue.value,
                label = { Text("Enter some content!") })
        }

    }
}
