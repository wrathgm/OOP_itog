package presenters;

public interface INotePresenter {
    void createNote(String title, String description, String date);

    void readAllNotes();

    void sortNotesByDate();

    void searchNotesByTitle(String title);

    void searchNotesByDateRange(String startDate, String endDate);
}
