package ru.otus.springproject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.springproject.service.AppRunnerService;

@PropertySource("classpath:property")
@Configuration
public class AppConfig {
    @Bean
    AppRunnerService AppRunnerService(@Value("${file.path}") String path, @Value("${right.answers}") Integer count) {
        return new AppRunnerService(path, count);
    }
}
