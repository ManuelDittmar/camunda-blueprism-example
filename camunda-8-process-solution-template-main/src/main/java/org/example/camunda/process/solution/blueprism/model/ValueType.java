package org.example.camunda.process.solution.blueprism.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public enum ValueType {
    BINARY("Binary"),

    COLLECTION("Collection"),

    DATE("Date"),

    FLAG("Flag"),

    IMAGE("Image"),

    NUMBER("Number"),

    PASSWORD("Password"),

    TEXT("Text"),

    TIME("Time"),

    TIMESPAN("TimeSpan");

    private String value;

    ValueType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
