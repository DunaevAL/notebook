package presenter;


public interface NotebookPresenter {
    void onAddNote();
    void onViewNotesForDay();
    void onViewNotesForWeek();
    void onSearchNotesByKeyword();
    void onSortByDateTime();
    void onSortByDescription();
    void onSaveNotebook();
    void onLoadNotebook();
}

