package com.example.notepadd.Adapter;

import com.example.notepadd.entities.Notes;

import java.util.List;

public interface SharedPreferencesNoteDao {
    // Insert a note
    void insertNote(Notes note);

    // Get all notes
    List<Notes> getAllNotes();

    // Delete a note
    void deleteNote(Notes note);
}
