package ru.otus.spring.hw02.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring.hw02.dao.QuestionDao;
import ru.otus.spring.hw02.dao.QuestionDaoImpl;


@Configuration
public class DaoConfig {

    @Bean
    public QuestionDao questionDao(){
        return new QuestionDaoImpl("questions.csv","answers.csv" );
    }
}
