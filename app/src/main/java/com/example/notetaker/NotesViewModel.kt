package com.example.notetaker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.notetaker.db.Note
import com.example.notetaker.db.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import android.content.Context
import com.example.notetaker.db.NoteDao
import com.example.notetaker.db.NotesDb

class NotesViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(NotesUIState())
    public val uiState: StateFlow<NotesUIState> = _uiState.asStateFlow()
    val repository = NotesRepository()

    fun updateAllNotes(notes: List<Note>) {
        _uiState.update { currentState ->
            currentState.copy(notes)
        }
    }

//    fun loadAllNotes() {
//        val notes = repository.getAllNotes()
//        updateAllNotes(notes)
//    }
}


data class NotesUIState(
    val notes: List<Note> = listOf()
)

