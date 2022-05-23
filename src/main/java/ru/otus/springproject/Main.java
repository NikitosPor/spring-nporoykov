package ru.otus.springproject;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.springproject.service.ScannerCSVService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        ScannerCSVService file = context.getBean(ScannerCSVService.class);
        file.saveQuestion();
        file.printQuestions();
    }

}
