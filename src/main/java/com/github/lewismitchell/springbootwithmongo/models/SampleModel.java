package com.github.lewismitchell.springbootwithmongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("sample-data")
public class SampleModel {

    @Id
    private String id;

    private String name;
    private String description;

    SampleModel() {}

    public SampleModel(String name, String description) {
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
