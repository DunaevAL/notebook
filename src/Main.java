import model.Note;
import model.Notebook;
import model.NotebookStorage;
import presenter.NotebookPresenter;
import presenter.NotebookPresenterImpl;
import view.ConsoleNotebookView;
import view.NotebookView;


public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        NotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenterImpl(view, notebook);

        presenter.onAddNote();
        presenter.onViewNotesForDay();
        presenter.onViewNotesForWeek();
        presenter.onSearchNotesByKeyword();
        presenter.onSortByDateTime();
        presenter.onSortByDescription();
        presenter.onSaveNotebook();
        presenter.onLoadNotebook();
    }
}
