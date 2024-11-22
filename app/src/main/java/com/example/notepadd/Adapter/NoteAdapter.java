package com.example.notepadd.Adapter;


import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notepadd.R;
import com.example.notepadd.entities.Notes;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Notes> notes;
    public NoteAdapter(List<Notes> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.background_note,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
            holder.setNote(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle, textNote, textCategory, textDate, textReminder;

        NoteViewHolder(@NonNull View itemView)  {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textNote = itemView.findViewById(R.id.textNote);
            textCategory = itemView.findViewById(R.id.Category);
            textDate = itemView.findViewById(R.id.Date);
            textReminder = itemView.findViewById(R.id.Reminder);


        }
        void setNote(Notes note) {
            textTitle.setText(note.getTitle());
            if(note.getNote().trim().isEmpty()){
                    textNote.setVisibility(View.GONE);
                } else {
                    textNote.setText(note.getNote());
                }
                    textCategory.setText(note.getCategory());
                    textReminder.setText(note.getReminder());
                    textDate.setText(note.getDate());
            }



        }
    }



