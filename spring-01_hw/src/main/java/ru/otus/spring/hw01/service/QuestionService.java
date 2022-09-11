package ru.otus.spring.hw01.service;

import ru.otus.spring.hw01.domain.Questions;

import java.io.IOException;

public interface QuestionService {

    Questions getQuestions() throws IOException;

}
