package presenters;

import java.util.List;

import models.Note;
import services.NoteService;

public class NotePresenter implements INotePresenter {
    public NoteService noteService;

    public NotePresenter(NoteService noteService) {
        this.noteService = noteService;
    }

    // Метод для сортировки записей по дате
    public void sortNotesByDate() {
        List<Note> sortedNotes = noteService.sortByDate();
        for (Note note : sortedNotes) {
            System.out.println(note.toString());
        }
    }

    // Метод для поиска записей по заголовку
    public void searchNotesByTitle(String title) {
        List<Note> foundNotes = noteService.searchByTitle(title);
        if (foundNotes.isEmpty()) {
            System.out.println("Записей с заголовком '" + title + "' не найдено.");
        } else {
            for (Note note : foundNotes) {
                System.out.println(note.toString());
            }
        }
    }

    // Метод для поиска записей по диапазону дат
    public void searchNotesByDateRange(String startDate, String endDate) {
        List<Note> foundNotes = noteService.searchByDateRange(startDate, endDate);
        if (foundNotes.isEmpty()) {
            System.out.println("Записей с датами в указанном диапазоне не найдено.");
        } else {
            for (Note note : foundNotes) {
                System.out.println(note.toString());
            }
        }
    }

    public NoteService getNoteService() {
        return noteService;
    }

    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((noteService == null) ? 0 : noteService.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NotePresenter other = (NotePresenter) obj;
        if (noteService == null) {
            if (other.noteService != null)
                return false;
        } else if (!noteService.equals(other.noteService))
            return false;
        return true;
    }

    @Override
    public void createNote(String title, String description, String date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createNote'");
    }

    @Override
    public void readAllNotes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readAllNotes'");
    }

}
