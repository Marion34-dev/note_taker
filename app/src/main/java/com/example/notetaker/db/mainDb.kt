package com.example.notetaker.db

import android.app.Application
import android.app.Service
import androidx.room.Room

class DatabaseService : Application() {
    val db = Room.databaseBuilder(
        applicationContext,
        NotesDb::class.java, "rooms_db"
    ).build()

    fun getInstance(): NotesDb {
        return db
    }
}

