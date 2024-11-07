package com.example.notetaker.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities= [Note::class],version=1)
abstract class NotesDb: RoomDatabase() {
    abstract fun notesDao(): NoteDao
}