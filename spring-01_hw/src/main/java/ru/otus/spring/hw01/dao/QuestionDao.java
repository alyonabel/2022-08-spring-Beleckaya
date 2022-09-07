package ru.otus.spring.hw01.dao;

import ru.otus.spring.hw01.domain.Question;
import java.io.IOException;

public interface QuestionDao{

    Question findQuestions() throws IOException;

}
