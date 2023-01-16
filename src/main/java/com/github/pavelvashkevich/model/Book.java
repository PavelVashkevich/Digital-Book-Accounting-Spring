package com.github.pavelvashkevich.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Book {

    private int id;
    @NotEmpty
    @Size(min = 2, max = 100, message = "Length of book name should be between 2 and 100 characters.")
    private String name;
    @NotEmpty
    @Size(min = 2, max = 100, message = "Length of author's name should be between 2 and 100 characters.")
    private String author;
    @Positive(message = "Year of public should be positive number.")
    private int yearOfPublish;
    private Integer personId;

    public Book(int id, String name, String author, int yearOfPublish, Integer personId) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
        this.personId = personId;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
