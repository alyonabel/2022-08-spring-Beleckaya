package ru.otus.spring.hw01.dao;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuestionDaoImplTest {

    @Test
    @DisplayName("If fileName is null, then NullPointerException")
    public void findQuestions() throws NullPointerException {

        QuestionDaoImpl que = new QuestionDaoImpl(null);
        Throwable thrown = assertThrows(NullPointerException.class, que::findQuestions);
    }
}
