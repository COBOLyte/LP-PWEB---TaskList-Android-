package com.example.tasklist.classes;

import java.util.Date;

public class Task {
    private final String title;
    private static final Date creationDate = new Date();
    private final Date endDate;

    public Task(String title, Date endDate) {
        this.title = title;
        this.endDate = endDate;
    }

    public String getTitle() {
        return this.title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
