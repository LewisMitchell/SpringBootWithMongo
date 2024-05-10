package com.github.lewismitchell.springbootwithmongo.forms;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SampleModelForm {

    @NotNull
    @Size(min = 1)
    private String name;

    @NotNull
    @Size(min = 1)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
