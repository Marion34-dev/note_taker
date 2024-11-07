package com.example.notetaker.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Room

@Dao
interface NoteDao {
    @Insert
    fun insert(note: Note)

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): List<Note>

    @Query("SELECT * FROM notes_table WHERE uid=:noteId")
    fun getNoteById(noteId: Int): Note?

    @Query("DELETE FROM notes_table WHERE uid=:noteId")
    fun deleteById(noteId: Int)

    @Query("UPDATE notes_table SET title=:noteTitle, content=:noteContent WHERE uid=:noteId")
    fun updateById(noteId: Int, noteTitle: String, noteContent: String)
}

