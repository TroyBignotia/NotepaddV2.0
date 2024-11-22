package com.example.notepadd.activities;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.notepadd.Adapter.SharedPreferencesNoteDaoImpl;
import com.example.notepadd.R;
import com.example.notepadd.entities.Notes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CreateNoteActivity extends AppCompatActivity {
    private EditText inputNoteTitle, inputNote;
    private TextView editedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        inputNoteTitle = findViewById(R.id.inputNoteTitle);
        inputNote = findViewById(R.id.inputNote);
        editedDate = findViewById(R.id.editedDate);
        ImageView imageBack = findViewById(R.id.imageBack);
        ImageView imageSave = findViewById(R.id.imageSave);

        imageBack.setOnClickListener(v -> onBackPressed());

        // Set the current date
        editedDate.setText(
                new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault()).format(new Date())
        );

        imageSave.setOnClickListener(v -> updateNote());
    }

    private void updateNote() {
        if (inputNoteTitle.getText().toString().isEmpty()) {
            Toast.makeText(this, "Title cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        } else if (inputNote.getText().toString().isEmpty()) {
            Toast.makeText(this, "Note cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new note
        Notes note = new Notes(0);
        note.setTitle(inputNoteTitle.getText().toString());
        note.setNote(inputNote.getText().toString());
        note.setDate(
                new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault()).format(new Date())
        );

        // Use SharedPreferencesNoteDaoImpl to insert the note
        SharedPreferencesNoteDaoImpl.getInstance().insertNote(note);

        Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show();
        finish();
    }
}
