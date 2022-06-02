package ru.otus.springproject.service;

import ru.otus.springproject.domain.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppRunnerService {
    private Integer rightAnswersCounter = 0;
    private String inputLine;
    private Student student;
    private final ScannerCSVService scanner;
    private final Integer minRightAnswers;

    private void askStudentName() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите ваше имя и фамилию через пробел и нажмите Enter:");
        this.inputLine = reader.readLine();
    }

    private void makeStudentWithNameAndSureName() throws IOException {
        String name = this.inputLine.substring(0, this.inputLine.indexOf(" "));
        String sureName = this.inputLine.substring(this.inputLine.indexOf(" ") + 1);
        this.student = new Student(name, sureName);
    }

    private void printResults() {
        System.out.println("Студент " + student.getFullName() + " ответил правильно на " + rightAnswersCounter + " вопроса(ов)");
        if (rightAnswersCounter < minRightAnswers) {
            System.out.println("Зачет не сдан");
        } else {
            System.out.println("Зачет сдан");
        }
    }

    public void run() throws IOException {
        askStudentName();
        makeStudentWithNameAndSureName();
        rightAnswersCounter = scanner.askAllQuestionsAndReturnCounter();
        printResults();
    }

    public AppRunnerService(String filePath, Integer minRightAnswers) {
        this.scanner = new ScannerCSVService(filePath);
        this.minRightAnswers = minRightAnswers;
    }
}
