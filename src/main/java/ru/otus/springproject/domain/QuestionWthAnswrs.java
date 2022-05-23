package ru.otus.springproject.domain;

import lombok.Data;

@Data
public class QuestionWthAnswrs {
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
}
