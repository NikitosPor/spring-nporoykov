package ru.otus.springproject.service;

import ru.otus.springproject.dao.FilePathDao;
import ru.otus.springproject.domain.QuestionWithAnswers;

import java.io.IOException;
import java.util.List;

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
                )
        );
    }
}
