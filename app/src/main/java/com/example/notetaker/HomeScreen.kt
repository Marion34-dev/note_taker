package com.example.notetaker

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController


@Composable
fun HomeScreen(
    notesViewModel: NotesViewModel = viewModel(),
    navController: NavController
) {
    val notesUIState by notesViewModel.uiState.collectAsState()
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "NotePal",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Button(
                onClick = { navController.navigate("edit") }
            ) {
                Text(
                    "Add Note"
                )
            }
        }
        Spacer(Modifier.padding(bottom = 32.dp))
       notesUIState.notes.forEachIndexed{index, note ->  NoteCard(note.title, index, navController)}
    }
}

@Composable
fun NoteCard(
    title: String,
    id: Int,
    navController: NavController
) {
    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
        .clickable(enabled = true, onClick = {navController.navigate("edit/$id")})
        ) {
    Text(title)
    }
}