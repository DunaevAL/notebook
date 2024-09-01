package model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class Notebook implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Note> notes;

    public Notebook() {
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotesForDay(LocalDate date) {
        return notes.stream()
                .filter(note -> note.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Note> getNotesForWeek(LocalDate startOfWeek) {
        return notes.stream()
                .filter(note -> !note.getDate().isBefore(startOfWeek) && !note.getDate().isAfter(startOfWeek.plusDays(6)))
                .collect(Collectors.toList());
    }

    public List<Note> searchNotesByKeyword(String keyword) {
        return notes.stream()
                .filter(note -> note.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Note> getAllNotes() {
        return new ArrayList<>(notes);
    }

    public void sortByDateTime() {
        notes.sort(Comparator.comparing(Note::getDate).thenComparing(Note::getTime));
    }

    public void sortByDescription() {
        notes.sort(Comparator.comparing(Note::getDescription));
    }
}


