package ru.otus.spring.hw02.dao;

import ru.otus.spring.hw02.domain.Question;
import java.io.IOException;


public interface QuestionDao{
    Question findQuestions() throws IOException;
}
