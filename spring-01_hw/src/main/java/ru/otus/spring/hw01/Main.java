package ru.otus.spring.hw01;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.hw01.domain.Questions;
import ru.otus.spring.hw01.service.QuestionService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionService service = context.getBean(QuestionService.class);
        service.getQuestions();
        context.close();
    }
}