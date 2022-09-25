package ru.otus.spring.hw02.service;

import ru.otus.spring.hw02.domain.Question;

import java.io.IOException;


public interface QuestionService {

    void startTest() throws IOException;

    Question getQuestions() throws IOException;

    void getResult() throws IOException;
}
