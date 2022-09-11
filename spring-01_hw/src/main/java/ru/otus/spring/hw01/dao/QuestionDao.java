package ru.otus.spring.hw01.dao;

import ru.otus.spring.hw01.domain.Questions;

import java.io.IOException;

public interface QuestionDao{

    Questions findQuestions() throws IOException;

}
