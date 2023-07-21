import java.util.Scanner;

import presenters.NotePresenter;
import repositories.FileNoteRepository;
import repositories.NoteRepository;
import services.NoteService;

public class Main {
    public static void main(String[] args) {
        // Создаем объекты Model, View и Presenter
        NoteRepository noteRepository = new FileNoteRepository(); // Используем реализацию хранилища в файле
        NoteService noteService = new NoteService(noteRepository);
        NotePresenter notePresenter = new NotePresenter(noteService);
        NoteView noteView = new NoteView(notePresenter);

        // Инициализируем View
        noteView.initialize();

        // Запускаем цикл приложения
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить запись");
            System.out.println("2. Просмотреть все записи");
            System.out.println("3. Сортировать записи по дате");
            System.out.println("4. Поиск записей по заголовку");
            System.out.println("5. Поиск записей по дате");
            System.out.println("6. Выход");
            System.out.print("Введите номер действия: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем лишний символ перевода строки

            switch (choice) {
                case 1:
                    System.out.print("Введите заголовок записи: ");
                    String title = scanner.nextLine();
                    System.out.print("Введите описание записи: ");
                    String description = scanner.nextLine();
                    System.out.print("Введите дату записи: ");
                    String date = scanner.nextLine();
                    notePresenter.noteService.createNote(title, description, date);
                    break;
                case 2:
                    notePresenter.getNoteService().readAllNotes();
                    break;
                case 3:
                    notePresenter.sortNotesByDate();
                    break;
                case 4:
                    System.out.print("Введите заголовок для поиска: ");
                    String searchTitle = scanner.nextLine();
                    notePresenter.searchNotesByTitle(searchTitle);
                    break;
                case 5:
                    System.out.print("Введите начальную дату для поиска (формат: ГГГГ-ММ-ДД): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Введите конечную дату для поиска (формат: ГГГГ-ММ-ДД): ");
                    String endDate = scanner.nextLine();
                    notePresenter.searchNotesByDateRange(startDate, endDate);
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
            System.out.println();
        }

        // Завершаем работу приложения
        scanner.close();
        noteView.cleanup();
    }
}
