package ru.otus.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.springproject.dao.MinRightQuestionsDao;
import ru.otus.springproject.domain.Student;

import java.io.IOException;

@Service
public class AppRunService {
    Student student;
    int minRightAnswersLimit;
    int rightAnswersCounter;
    private final QuestionAskService questionAskService;
    ResultsOutputService resultsOutputService = new ResultsOutputService();
    private final StudentCreationService studentCreationService = new StudentCreationService();

    //@Autowired
    public AppRunService(QuestionAskService questionAskService, MinRightQuestionsDao count) {
        this.questionAskService = questionAskService;
        minRightAnswersLimit = count.getMinRightQuestionsCount();
    }

    public void run() throws IOException {
        student = studentCreationService.askNameAndCreateStudent();
        rightAnswersCounter = questionAskService.askAllQuestionsAndReturnCounter();
        resultsOutputService.printResults(student, rightAnswersCounter, minRightAnswersLimit);
    }
}
