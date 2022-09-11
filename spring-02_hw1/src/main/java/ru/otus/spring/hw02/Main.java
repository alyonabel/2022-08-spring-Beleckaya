package ru.otus.spring.hw02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ru.otus.spring.hw02.service.QuestionService;

import java.io.IOException;

@Configuration
@ComponentScan ("ru.otus.spring.hw02")
public class Main {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Main.class);
        QuestionService service = context.getBean(QuestionService.class);
        service.getQuestions();
        context.close();
    }
}