package ru.otus.springproject.domain;

import java.util.ArrayList;
import java.util.List;

public final class QuestionWithAnswers {
   // private final ArrayList<String> questionAndAnswers;
    private final String question;
    private List<String> answers = new ArrayList<>();
    private final String rightAnswer;

    public QuestionWithAnswers(ArrayList<String> list) {
        this.question = list.get(0);
        this.answers.add(list.get(1));
        this.answers.add(list.get(2));
        this.answers.add(list.get(3));
        this.rightAnswer = list.get(4);
    }

    public String getQuestion() {
        return this.question;
    }

    public String getAnswerX(int i) {
        return this.answers.get(i);
    }

    public String getRightAnswer() {
        return this.rightAnswer;
    }
}
