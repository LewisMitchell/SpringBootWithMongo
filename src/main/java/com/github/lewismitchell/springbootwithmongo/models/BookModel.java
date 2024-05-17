package com.github.lewismitchell.springbootwithmongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("books")
public class BookModel {

    @Id
    private String id;

    private String name;
    private String author;

    BookModel() {}

    public BookModel(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() { return author; }
}
