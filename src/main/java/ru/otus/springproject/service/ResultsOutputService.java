package ru.otus.springproject.service;

import ru.otus.springproject.domain.Student;

public class ResultsOutputService {

    void printResults(Student student, int rightAnswersCounter, int minRightAnswers) {
        System.out.println("Студент " + student.getFullName() + " ответил правильно на " + rightAnswersCounter + " вопроса(ов)");
        if (rightAnswersCounter < minRightAnswers) {
            System.out.println("Зачет не сдан");
        } else {
            System.out.println("Зачет сдан");
        }
    }
}
