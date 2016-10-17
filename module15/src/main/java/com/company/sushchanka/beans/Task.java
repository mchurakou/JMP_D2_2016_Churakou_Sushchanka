package com.company.sushchanka.beans;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by alt-hanny on 17.10.2016.
 */
public class Task implements Serializable{
    private LocalDate creationDate;
    private LocalDate deadLine;
    private String name;
    private String category;

    public Task(String name, String category, LocalDate creationDate, LocalDate deadLine) {
        this.creationDate = creationDate;
        this.deadLine = deadLine;
        this.name = name;
        this.category = category;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Task: " + name + ", Category: " + category + ", Date of creation: " + creationDate + ", Dead Line: " +
                deadLine;
    }
}
