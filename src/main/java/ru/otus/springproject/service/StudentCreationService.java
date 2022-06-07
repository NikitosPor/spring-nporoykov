package ru.otus.springproject.service;

import ru.otus.springproject.domain.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentCreationService {

    public Student askNameAndCreateStudent() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ваше имя и фамилию через пробел и нажмите Enter:");
        String inputLine = reader.readLine();
        String name = inputLine.substring(0, inputLine.indexOf(" "));
        String sureName = inputLine.substring(inputLine.indexOf(" ") + 1);
        return new Student(name, sureName);
    }
}
