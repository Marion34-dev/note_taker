package com.example.notetaker.db

class NotesRepository () {
    val db = DatabaseService()
    fun insertNote(note: Note) {
        db.getInstance().notesDao().insert(note)
    }

    fun getAllNotes(): List<Note> {
        return db.getInstance().notesDao().getAllNotes()
    }

    fun getNoteById(id: Int): Note? {
        return db.getInstance().notesDao().getNoteById(id)
    }

    fun deleteById(id:Int) {
        db.getInstance().notesDao().deleteById(id)
    }

    fun updateById(id:Int, title:String, content:String) {
        return db.getInstance().notesDao().updateById(id, noteContent=content, noteTitle = title)
    }
}
