package ru.otus.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.otus.springproject.dao.LinesFromCsvFileDao;
import ru.otus.springproject.domain.QuestionWithAnswers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

@Service
public class QuestionAskService {
    private final LinesFromCsvFileDao linesFromCsvFileDao;

    //@Autowired
    public QuestionAskService(LinesFromCsvFileDao linesFromCsvFileDao) {
        this.linesFromCsvFileDao = linesFromCsvFileDao;
    }

    public Integer askAllQuestionsAndReturnCounter() throws IOException {
        int counterOfRightAnswers = 0;
        List<QuestionWithAnswers> listOfQuestionsWithAnswers = linesFromCsvFileDao.getAllQuestionsAndAnswers();
        for (QuestionWithAnswers stringLine : listOfQuestionsWithAnswers) {
            String answer;
            String rightAnswer = stringLine.getRightAnswer();
            System.out.println(stringLine.getQuestion() + " "
                    + stringLine.getAnswerX(0) + " "
                    + stringLine.getAnswerX(1) + " "
                    + stringLine.getAnswerX(2)
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
