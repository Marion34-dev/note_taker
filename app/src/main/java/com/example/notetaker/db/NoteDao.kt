package com.example.notetaker.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note)

    @Query("SELECT * FROM notes_table")
    suspend fun getAllNotes(): List<Note>

    @Query("SELECT * FROM notes_table WHERE id=:noteId")
    suspend fun getNoteById(noteId: Int): Note?

    @Query("DELETE FROM notes_table WHERE id=:noteId")
    suspend fun deleteById(noteId: Int)

    @Query("UPDATE notes_table SET title=:noteTitle, content=:noteContent WHERE id=:noteId")
    suspend fun updateById(noteId: Int, noteTitle: String, noteContent: String)
}