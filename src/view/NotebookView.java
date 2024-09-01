package view;
import model.Note;
import model.Notebook;
import model.NotebookStorage;

import model.Note;

import java.time.LocalDate;
import java.util.List;

public interface NotebookView {
    void showNotes(List<Note> notes);
    void showMessage(String message);
    Note getNoteFromUser();
    LocalDate getDateFromUser();
    String getKeywordFromUser();
    String getFileNameFromUser();
}

