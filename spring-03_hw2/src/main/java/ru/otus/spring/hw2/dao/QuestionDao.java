package ru.otus.spring.hw2.dao;

import ru.otus.spring.hw2.domain.Question;


public interface QuestionDao {

    Question findQuestions();

    int resultTest();
}
