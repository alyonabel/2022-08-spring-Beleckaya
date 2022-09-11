package ru.otus.spring.hw02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.hw02.dao.QuestionDao;
import ru.otus.spring.hw02.service.QuestionService;
import ru.otus.spring.hw02.service.QuestionServiceImpl;

@Configuration
public class ServiceConfig {

    @Bean
    public QuestionService questionService(QuestionDao dao){
        return new QuestionServiceImpl(dao); };
}
