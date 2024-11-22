package com.example.notepadd.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notepadd.Adapter.SharedPreferencesNoteDaoImpl;
import com.example.notepadd.R;
import com.example.notepadd.entities.Notes;

public class MainActivity2 extends AppCompatActivity {

    private SharedPreferencesNoteDaoImpl noteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the DAO (pass the context)
        noteDao = new SharedPreferencesNoteDaoImpl(getApplicationContext());

        ImageView imageAddNoteMain = findViewById(R.id.imageAddNoteMain);
        imageAddNoteMain.setOnClickListener(v -> startActivityForResult(
                new Intent(MainActivity2.this, CreateNoteActivity.class),
                1
        ));

        getNotes();
    }

    private void getNotes() {
        // Retrieve all notes from SharedPreferences
        List<Notes> notes = noteDao.getAllNotes();
        if (notes.isEmpty()) {
            Toast.makeText(this, "No notes found", Toast.LENGTH_SHORT).show();
        }
    }
}
