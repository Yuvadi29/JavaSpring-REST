package com.example.RestApi.model;

import jakarta.validation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Data")

public class Data {

    // Id
    @Id
    private long id;

    @NotBlank // Not Null
    @Size(max = 100) // SiZe
    // We have an annotated name with @Indexed annotation and marked it as unique.
    // This creates a unique index on the name field.
    @Indexed(unique = true)
    private String name;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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