package ru.otus.spring.hw02.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class QuestionDaoImplTest  {

    @Test
    @DisplayName("If fileName is null, then NullPointerException")
    void findQuestions() throws NullPointerException {

        QuestionDaoImpl que = new QuestionDaoImpl(null);
        assertThrows(NullPointerException.class, que::findQuestions);

    }
}