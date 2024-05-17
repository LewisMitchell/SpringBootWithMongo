package com.github.lewismitchell.springbootwithmongo.forms;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BookModelForm {

    @NotNull
    @Size(min = 1)
    private String name;

    @NotNull
    @Size(min = 1)
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String description) {
        this.author = description;
    }
}
