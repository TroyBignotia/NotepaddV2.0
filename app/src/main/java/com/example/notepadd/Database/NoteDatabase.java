package com.example.notepadd.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notepadd.Adapter.SharedPreferencesNoteDao;
import com.example.notepadd.entities.Notes;



@Database(entities = Notes.class, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    private static volatile NoteDatabase INSTANCE;
    private static NoteDatabase noteDatabase;

    public static synchronized NoteDatabase getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    NoteDatabase.class,
                    "notes_database"
            ).fallbackToDestructiveMigration().build();
        }
        return noteDatabase;
    }

    public abstract SharedPreferencesNoteDao noteDao();



}
