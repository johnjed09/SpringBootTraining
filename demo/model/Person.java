package com.example.demo.model;

import java.util.UUID;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private final UUID id;
    @NonNull
    private final String name;
    private final String birthdate;
    private int age;

    public Person(@JsonProperty("id") UUID id,
            @JsonProperty("name") String name,
            @JsonProperty("birthdate") String birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public Person(UUID id, String name, String birthdate, int age) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.age = age;
    }

    public UUID getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthDate() {
        return this.birthdate;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
