package ru.otus.springproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.springproject.service.AppRunService;

import java.io.IOException;

@ComponentScan
public class Main {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        AppRunService app = context.getBean(AppRunService.class);
        app.run();
    }

}
