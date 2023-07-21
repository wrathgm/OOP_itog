package services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import models.Note;
import repositories.NoteRepository;

public class NoteService {
    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void addNote(Note note) {
        List<Note> notes = noteRepository.loadNotes();
        notes.add(note);
        noteRepository.saveNotes(notes);
    }

    public List<Note> getAllNotes() {
        return noteRepository.loadNotes();
    }

    // Метод для сортировки записей по дате
    public List<Note> sortByDate() {
        List<Note> notes = noteRepository.loadNotes();
        notes.sort(Comparator.comparing(Note::getDate));
        return notes;
    }

    // Метод для поиска записей на конкретный день
    public List<Note> searchByDate(String date) {
        List<Note> notes = noteRepository.loadNotes();
        return notes.stream()
                .filter(note -> note.getDate().equals(date))
                .collect(Collectors.toList());
    }

    // Метод для удаления записи
    public void deleteNote(Note note) {
        List<Note> notes = noteRepository.loadNotes();
        notes.remove(note);
        noteRepository.saveNotes(notes);
    }

    // Метод для обновления записи
    public void updateNote(Note updatedNote) {
        List<Note> notes = noteRepository.loadNotes();
        for (int i = 0; i < notes.size(); i++) {
            Note note = notes.get(i);
            if (note.getId().equals(updatedNote.getId())) {
                notes.set(i, updatedNote);
                break;
            }
        }
        noteRepository.saveNotes(notes);
    }

    // Метод для поиска записей по заголовку
    public List<Note> searchByTitle(String title) {
        List<Note> notes = noteRepository.loadNotes();
        return notes.stream()
                .filter(note -> note.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    // Метод для поиска записей по диапазону дат
    public List<Note> searchByDateRange(String startDate, String endDate) {
        List<Note> notes = noteRepository.loadNotes();
        return notes.stream()
                .filter(note -> note.getDate().compareTo(startDate) >= 0 && note.getDate().compareTo(endDate) <= 0)
                .collect(Collectors.toList());
    }

    public void readAllNotes() {
        List<Note> notes = getAllNotes();
        for (Note note : notes) {
            System.out.println(note.toString());
        }
    }

    public void createNote(String title, String description, String date) {
        Note note = new Note(title, description, date);
        addNote(note);
    }

    // Остальные методы для работы с записями
}
