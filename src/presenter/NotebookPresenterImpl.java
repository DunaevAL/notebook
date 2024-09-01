package presenter;

import model.Note;
import model.Notebook;
import model.NotebookStorage;
import view.NotebookView;

import java.util.List;
import java.time.LocalDate;

public class NotebookPresenterImpl implements NotebookPresenter {
    private NotebookView view;
    private Notebook notebook;
    private NotebookStorage storage;

    public NotebookPresenterImpl(NotebookView view, Notebook notebook) {
        this.view = view;
        this.notebook = notebook;
        this.storage = new NotebookStorage();
    }

    @Override
    public void onAddNote() {
        Note note = view.getNoteFromUser();
        notebook.addNote(note);
        view.showMessage("Note added successfully!");
    }

    @Override
    public void onViewNotesForDay() {
        LocalDate date = view.getDateFromUser();
        List<Note> notes = notebook.getNotesForDay(date);
        view.showNotes(notes);
    }

    @Override
    public void onViewNotesForWeek() {
        LocalDate startOfWeek = view.getDateFromUser();
        List<Note> notes = notebook.getNotesForWeek(startOfWeek);
        view.showNotes(notes);
    }

    @Override
    public void onSearchNotesByKeyword() {
        String keyword = view.getKeywordFromUser();
        List<Note> notes = notebook.searchNotesByKeyword(keyword);
        view.showNotes(notes);
    }

    @Override
    public void onSortByDateTime() {
        notebook.sortByDateTime();
        view.showNotes(notebook.getAllNotes());
    }

    @Override
    public void onSortByDescription() {
        notebook.sortByDescription();
        view.showNotes(notebook.getAllNotes());
    }

    @Override
    public void onSaveNotebook() {
        String fileName = view.getFileNameFromUser();
        storage.saveToFile(notebook, fileName);
    }

    @Override
    public void onLoadNotebook() {
        String fileName = view.getFileNameFromUser();
        storage.loadFromFile(notebook, fileName);
        view.showNotes(notebook.getAllNotes());
    }
}



