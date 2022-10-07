package ru.otus.spring.hw02.dao;

import org.springframework.stereotype.Component;
import ru.otus.spring.hw02.domain.Question;

@Component
public interface QuestionDao {
    Question findQuestions();

    void resultTest();
}
