package com.example.notetaker.db

import android.content.Context
import androidx.room.Room

object DbBuilder {
    private var INSTANCE: NotesDb? =null
    fun getInstance(context: Context): NotesDb {
        if (INSTANCE == null) {
            synchronized(NotesDb::class) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDb:: class.java,
                    "notes_db"
                ).build()
            }
        }
        return INSTANCE!!
    }
}