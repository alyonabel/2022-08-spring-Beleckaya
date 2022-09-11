package ru.otus.spring.hw01.service;

import ru.otus.spring.hw01.dao.QuestionDao;
import ru.otus.spring.hw01.domain.Questions;

import java.io.IOException;

public class QuestionServiceImpl implements QuestionService{

    private final QuestionDao dao;

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }

    @Override
    public Questions getQuestions()  {
        System.out.println("\nHello! Let's start the test!\n");
        try {
           return dao.findQuestions();
        } catch (IOException e) {
            e.printStackTrace();
        }return null;
    }
}
