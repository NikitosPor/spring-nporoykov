package ru.otus.springproject.service;

import ru.otus.springproject.dao.FilePathDao;
import ru.otus.springproject.domain.QuestionWithAnswers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

public class ScannerCSVService {
    private final FilePathDao filePathDao;

    public ScannerCSVService(String filePath) {
        this.filePathDao = new FilePathDao(filePath);
    }

    public void printAllQuestionsWithAnswers() throws IOException {
        List<QuestionWithAnswers> listOfQuestionsWithAnswers = filePathDao.getAllQuestionsAndAnswers();
        listOfQuestionsWithAnswers.forEach(stringLine ->
                System.out.println(stringLine.getQuestion()
                        + stringLine.getAnswerA()
                        + stringLine.getAnswerB()
                        + stringLine.getAnswerC()
                        + stringLine.getRightAnswer()
                )
        );
    }

    public Integer askAllQuestionsAndReturnCounter() throws IOException {
        Integer counterOfRightAnswers = 0;
        List<QuestionWithAnswers> listOfQuestionsWithAnswers = filePathDao.getAllQuestionsAndAnswers();
        for(QuestionWithAnswers stringLine : listOfQuestionsWithAnswers){
            String answer;
            String rightAnswer = stringLine.getRightAnswer();
            System.out.println(stringLine.getQuestion()
                    + stringLine.getAnswerA()
                    + stringLine.getAnswerB()
                    + stringLine.getAnswerC()
            );
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите букву правильного ответа:");
            answer = reader.readLine();
            if (Objects.equals(answer, rightAnswer)) {
                counterOfRightAnswers++;
            }
        }

        return counterOfRightAnswers;
    }



}
