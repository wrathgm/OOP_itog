package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Notebook implements Serializable {
    private List<Note> notes;

    public Notebook() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getAllNotes() {
        return notes;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Notebook:\n");
        for (Note note : notes) {
            stringBuilder.append(note.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
