package ru.otus.springproject.domain;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class Student {
    private final String name;
    private final String sureName;

    public Student(String name, String sureName) {
        this.name = name;
        this.sureName = sureName;
    }

    public String getName(){
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public String getFullName(){
        return name + " " + sureName;
    }
}
