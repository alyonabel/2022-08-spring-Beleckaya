package ru.otus.hw.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import ru.otus.hw.dao.jdbc.GenreDaoJdbc;
import ru.otus.hw.domain.Genre;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Dao для работы с жанрами")
@JdbcTest
@Import(GenreDaoJdbc.class)
class GenreDaoTest {
    @Autowired
    private GenreDaoJdbc genreDaoJdbc;

    private static final int CURRENT_GENRES_COUNT = 1;
    private static final String CURRENT_GENRE = "novel";
    private static final String NEW_GENRES = "story";

    @BeforeTransaction
    void beforeTransaction(){
        System.out.println("beforeTransaction");
    }

    @AfterTransaction
    void afterTransaction(){
        System.out.println("afterTransaction");
    }

    @DisplayName("Количество жанров в БД")
    @Test
    void count() {
        assertThat(genreDaoJdbc.count()).isEqualTo(CURRENT_GENRES_COUNT);
    }

    @DisplayName("Добавление жанра в БД")
    @Test
    void insert() {
        genreDaoJdbc.insert(new Genre(2,NEW_GENRES));
        assertThat(genreDaoJdbc.getById(2).getGenreName()).isEqualTo(NEW_GENRES);
    }

    @DisplayName("Поиск жанра по id в БД")
    @Test
    void getById() {
        assertThat(genreDaoJdbc.getById(1).getGenreName()).isEqualTo(CURRENT_GENRE);
    }

    @DisplayName("Поиск жанра по имени в БД")
    @Test
    void getByGenre() {
        assertThat(genreDaoJdbc.getByGenre(CURRENT_GENRE).getId()).isEqualTo(1);
    }

    @DisplayName("Список всех авторов в БД")
    @Test
    void getAll() {
        assertThat(genreDaoJdbc.getAll().size()).isEqualTo(CURRENT_GENRES_COUNT);
    }

  }