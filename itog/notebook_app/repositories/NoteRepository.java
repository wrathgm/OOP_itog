package repositories;

import java.util.List;

import models.Note;

public interface NoteRepository {
    void saveNotes(List<Note> notes);

    List<Note> loadNotes();

    // Дополнительные методы для работы с хранилищем
    void deleteNote(Note note);

    void updateNote(Note note);

    List<Note> searchByTitle(String title);

    List<Note> searchByDateRange(String startDate, String endDate);
    // И другие методы, в зависимости от требований вашего проекта
}
