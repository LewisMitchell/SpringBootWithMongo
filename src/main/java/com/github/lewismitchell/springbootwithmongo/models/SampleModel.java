package com.github.lewismitchell.springbootwithmongo.models;

public class SampleModel {
    private String name;
    private String description;

    SampleModel() {}

    SampleModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
