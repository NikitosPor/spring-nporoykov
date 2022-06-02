package ru.otus.springproject.domain;

public final class StudentGrade {
    private final Student student;
    private final Integer grade;


    public StudentGrade(Student student, Integer grade){
        this.student = student;
        this.grade = grade;
    }
}
