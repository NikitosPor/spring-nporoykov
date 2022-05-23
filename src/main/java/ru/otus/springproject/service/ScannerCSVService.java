package ru.otus.springproject.service;

import ru.otus.springproject.dao.FilePathDao;
import ru.otus.springproject.domain.QuestionWthAnswrs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ScannerCSVService {
    private int index = 0;
    private final List<QuestionWthAnswrs> questionWthAnsrs = new ArrayList<>();
    private BufferedReader reader = null;

    public ScannerCSVService(FilePathDao file) throws FileNotFoundException {
        this.reader = new BufferedReader(new FileReader(file.getFilePath()));
    }

    public void saveQuestion() throws IOException {
        String line = null;
        while ((line = reader.readLine()) != null) {
            QuestionWthAnswrs questionWthAnswrs = new QuestionWthAnswrs();
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0) questionWthAnswrs.setQuestion(data);
                else if (index == 1) {
                    questionWthAnswrs.setAnswerA(data);
                } else if (index == 2) {
                    questionWthAnswrs.setAnswerB(data);
                } else if (index == 3) {
                    questionWthAnswrs.setAnswerC(data);
                } else
                    System.out.println("Data is incorrect");
                index++;
            }
            index = 0;
            this.questionWthAnsrs.add(questionWthAnswrs);
        }
        reader.close();
    }

    public void printQuestions() {
        for (int i = 0; i <= questionWthAnsrs.size() - 1; i++) {
            System.out.println(questionWthAnsrs.get(i).getQuestion() + " a)" + questionWthAnsrs.get(i).getAnswerA() + " b)" + questionWthAnsrs.get(i).getAnswerB() + " c)" + questionWthAnsrs.get(i).getAnswerC());
        }
    }
}
