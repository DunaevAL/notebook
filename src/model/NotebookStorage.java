package model;


import java.io.*;
import java.util.List;

public class NotebookStorage {

    public void saveToFile(Notebook notebook, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(notebook.getAllNotes());
            System.out.println("Notebook saved to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving notebook: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(Notebook notebook, String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Note> notes = (List<Note>) ois.readObject();
            notes.forEach(notebook::addNote);
            System.out.println("Notebook loaded from " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading notebook: " + e.getMessage());
        }
    }
}

