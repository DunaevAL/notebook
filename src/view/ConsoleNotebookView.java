package view;

import model.Note;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ConsoleNotebookView implements NotebookView {
    private Scanner scanner;

    public ConsoleNotebookView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showNotes(List<Note> notes) {
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
        } else {
            notes.forEach(System.out::println);
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public Note getNoteFromUser() {
        System.out.println("Enter date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.println("Enter time (HH:MM): ");
        LocalTime time = LocalTime.parse(scanner.nextLine());

        System.out.println("Enter description: ");
        String description = scanner.nextLine();

        return new Note(date, time, description);
    }

    @Override
    public LocalDate getDateFromUser() {
        System.out.println("Enter date (YYYY-MM-DD): ");
        return LocalDate.parse(scanner.nextLine());
    }

    @Override
    public String getKeywordFromUser() {
        System.out.println("Enter keyword for search: ");
        return scanner.nextLine();
    }

    @Override
    public String getFileNameFromUser() {
        System.out.println("Enter file name: ");
        return scanner.nextLine();
    }
}
