package ru.otus.springproject.domain;

import java.util.ArrayList;

public final class QuestionWithAnswers {
    private final ArrayList<String> questionAndAnswers;

    public QuestionWithAnswers(ArrayList<String> list) {
        this.questionAndAnswers=list;
    }

    public String getQuestion(){
       return this.questionAndAnswers.get(0);
    }

    public String getAnswerA(){
        return this.questionAndAnswers.get(1);
    }

    public String getAnswerB(){
        return this.questionAndAnswers.get(2);
    }

    public String getAnswerC(){
        return this.questionAndAnswers.get(3);
    }

    public String getRightAnswer(){
        return this.questionAndAnswers.get(4);
    }
}
