package com.teachmeskills.lesson_17.task_2.model;

import java.util.List;

public class Sonnet {

    private String authorFirstName;
    private String authorLastName;
    private String title;
    private List<String> line;

    public Sonnet() { }

    public Sonnet(String authorFirstName, String authorLastName, String title, List<String> line) {
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.title = title;
        this.line = line;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLine() {
        return line;
    }

    public void setLine(List<String> line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "Sonnet{" +
                "\n AuthorFirstName: '" + authorFirstName + '\'' +
                "\n AuthorLastName: '" + authorLastName + '\'' +
                "\n Title: '" + title + '\'' +
                "\n Line:\n " + line +
                "\n}";
    }

}
