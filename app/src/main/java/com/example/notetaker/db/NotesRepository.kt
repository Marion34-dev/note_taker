package com.example.notetaker.db

class NotesRepository (private val db: NotesDb) {
    private val noteDao = db.notesDao()
    suspend fun insertNote(note: Note) {
        noteDao.insert(note)
    }

    suspend fun getAllNotes(): List<Note> {
        return noteDao.getAllNotes()
    }

    suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)
    }

    suspend fun deleteById(id:Int) {
        return noteDao.deleteById(id)
    }

    suspend fun updateById(id:Int, title:String, content:String) {
        return noteDao.updateById(id, noteContent=content, noteTitle = title)
    }
}
