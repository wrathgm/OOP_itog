package models;

import java.io.Serializable;

public class Note implements Serializable {
    private String id;
    private String title;
    private String description;
    private String date;

    public Note() {
        // Пустой конструктор
    }

    public Note(String title, String description, String date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
