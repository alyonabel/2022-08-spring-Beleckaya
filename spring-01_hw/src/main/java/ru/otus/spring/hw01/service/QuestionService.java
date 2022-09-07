package ru.otus.spring.hw01.service;

import ru.otus.spring.hw01.domain.Question;

import java.io.IOException;

public interface QuestionService {

    Question getQuestions() throws IOException;

}
