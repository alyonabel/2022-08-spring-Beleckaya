package ru.otus.spring.hw02.service;

import java.io.IOException;


public interface QuestionService {

    void startTest() throws IOException;

    void getQuestions() throws IOException;

    void getResult() throws IOException;

    void introduceTest()throws IOException;
}
