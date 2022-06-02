package ru.otus.springproject;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.springproject.config.AppConfig;
import ru.otus.springproject.service.AppRunnerService;

import java.io.IOException;

@ComponentScan(basePackages = "config")
public class Main {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppRunnerService app = context.getBean(AppRunnerService.class);
        app.run();
    }

}
