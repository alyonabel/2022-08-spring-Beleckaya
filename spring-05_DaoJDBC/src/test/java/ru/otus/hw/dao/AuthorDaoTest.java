package ru.otus.hw.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import ru.otus.hw.dao.jdbc.AuthorDaoJdbc;
import ru.otus.hw.domain.Author;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dao для работы с авторами")
@JdbcTest
@Import(AuthorDaoJdbc.class)
class AuthorDaoTest {

    @Autowired
    private AuthorDaoJdbc authorDaoJdbc;

    private static final int CURRENT_AUTHORS_COUNT = 1;
    private static final String CURRENT_AUTHOR = "Gustave Flaubert";
    private static final String NEW_AUTHOR = "Ivan Turgenev";

    @BeforeTransaction
    void beforeTransaction(){
        System.out.println("beforeTransaction");
    }

    @AfterTransaction
    void afterTransaction(){
        System.out.println("afterTransaction");
    }

    @DisplayName("Количество авторов в БД")
    @Test
    void count() {
        assertThat(authorDaoJdbc.count()).isEqualTo(CURRENT_AUTHORS_COUNT);
    }

    @DisplayName("Добавление автора в БД")
    @Test
    void insert() {
        authorDaoJdbc.insert(new Author(2,NEW_AUTHOR));
        assertThat(authorDaoJdbc.getById(2).getAuthorName()).isEqualTo(NEW_AUTHOR);
    }

    @DisplayName("Поиск автора по id в БД")
    @Test
    void getById() {
       assertThat(authorDaoJdbc.getById(1).getAuthorName()).isEqualTo(CURRENT_AUTHOR);
    }

    @DisplayName("Поиск автора по имени в БД")
    @Test
    void getByAuthor() {
        assertThat(authorDaoJdbc.getByAuthor(CURRENT_AUTHOR).getId()).isEqualTo(1);
    }

    @DisplayName("Список всех авторов в БД")
    @Test
    void getAll() {
        assertThat(authorDaoJdbc.getAll().size()).isEqualTo(CURRENT_AUTHORS_COUNT);
    }

}