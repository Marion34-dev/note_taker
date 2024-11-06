package com.example.notetaker

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotesViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(NotesUIState())
    public val uiState: StateFlow<NotesUIState> = _uiState.asStateFlow()
    fun getAllNotes(): List<Note> {
        return _uiState.value.notes
    }
}

data class NotesUIState(
    val notes: List<Note>  = notesData
)

class Note(val title: String = "", val content: String = "")
