package ru.otus.springproject.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:application.properties")
@Component
public final class MinRightQuestionsDao {
    private final int minRightQuestionsCount;

    public MinRightQuestionsDao(@Value("${right.answers}") int count){
        minRightQuestionsCount = count;
    }

    public int getMinRightQuestionsCount() {
        return minRightQuestionsCount;
    }
}
