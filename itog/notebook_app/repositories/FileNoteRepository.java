package repositories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import models.Note;

public class FileNoteRepository implements NoteRepository {
    private List<Note> notes = new ArrayList<>();
    private final String filename = "notes.dat";

    public FileNoteRepository() {
        loadNotesFromFile();
    }

    @Override
    public void saveNotes(List<Note> notes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(notes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Note> loadNotes() {
        return notes;
    }

    private void loadNotesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Note> loadedNotes = (List<Note>) ois.readObject();
            notes.addAll(loadedNotes);
        } catch (IOException | ClassNotFoundException e) {
            // Если файл не найден или произошла ошибка десериализации, просто игнорируем и
            // создаем новый список записей
        }
    }

    @Override
    public void deleteNote(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteNote'");
    }

    @Override
    public void updateNote(Note note) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateNote'");
    }

    @Override
    public List<Note> searchByTitle(String title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByTitle'");
    }

    @Override
    public List<Note> searchByDateRange(String startDate, String endDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByDateRange'");
    }

}