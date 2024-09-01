package model;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

public class Note implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate date;
    private LocalTime time;
    private String description;

    public Note(LocalDate date, LocalTime time, String description) {
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return date + " " + time + " - " + description;
    }
}



