package com.example.notepadd.entities;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Notes {
    private int id;
    private String title;
    private String note;
    private String date;

    // Constructors, getters, and setters

    public Notes(String title, String note, String date) {
        this.title = title;
        this.note = note;
        this.date = date;
    }

    // Convert a list of Notes objects to JSON
    public static String toJson(List<Notes> notesList) {
        Gson gson = new Gson();
        return gson.toJson(notesList);
    }

    // Convert JSON back into a list of Notes objects
    public static List<Notes> fromJson(String json) {
        Gson gson = new Gson();
        // Convert the JSON into a List of Notes objects
        Notes[] notesArray = gson.fromJson(json, Notes[].class);
        return new ArrayList<>(Arrays.asList(notesArray));
    }
}
