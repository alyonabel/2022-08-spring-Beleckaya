package ru.otus.hw.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import ru.otus.hw.dao.jdbc.BookDaoJdbc;

import static org.assertj.core.api.Assertions.*;


@DisplayName("Dao для работы с книгами")
@JdbcTest
@Import(BookDaoJdbc.class)
class BookDaoTest {

    private static final int EXISTING_COUNT = 1;
    private static final int EXISTING_BOOKS_ID = 1;

    private static final String EXISTING_BOOKS_NAME = "Madame Bovary";

    private static final long EXISTING_BOOKS_AUTHOR_ID = 1;

    private static final long EXISTING_BOOKS_GENRE_ID = 1;

    @Autowired
    private BookDaoJdbc bookDaoJdbc;

    @BeforeTransaction
    void beforeTransaction(){
        System.out.println("beforeTransaction");
    }

    @AfterTransaction
    void afterTransaction(){
        System.out.println("afterTransaction");
    }

    @DisplayName("Количество книг в БД")
    @Test
    void count() {
        int actualBooksCount = bookDaoJdbc.count();
        assertThat(actualBooksCount).isEqualTo(EXISTING_COUNT);
    }

    @DisplayName("Добавление книг в БД")
    @Test
    void insert() {
        assertThat(bookDaoJdbc.count()).isEqualTo(EXISTING_COUNT);
        bookDaoJdbc.insert(2,"Salambo",EXISTING_BOOKS_AUTHOR_ID,EXISTING_BOOKS_GENRE_ID);
        assertThat(bookDaoJdbc.count()).isEqualTo(EXISTING_COUNT+1);
        assertThat(bookDaoJdbc.getById(2).getName()).isEqualTo("Salambo");
    }

    @DisplayName("Обновление книг в БД")
    @Test
    void update() {
        assertThat(bookDaoJdbc.getById(EXISTING_BOOKS_ID).getName()).isEqualTo(EXISTING_BOOKS_NAME);
        bookDaoJdbc.update(EXISTING_BOOKS_ID,EXISTING_BOOKS_NAME+"2",EXISTING_BOOKS_AUTHOR_ID,EXISTING_BOOKS_GENRE_ID);
        assertThat(bookDaoJdbc.getById(EXISTING_BOOKS_ID).getName()).isEqualTo(EXISTING_BOOKS_NAME+"2");
    }

    @DisplayName("Книга по id")
    @Test
    void getById() {
        assertThat(bookDaoJdbc.getById(EXISTING_BOOKS_ID).getName()).isEqualTo(EXISTING_BOOKS_NAME);
    }

    @DisplayName("Список книг")
    @Test
    void getAll() {
        assertThat(bookDaoJdbc.getAll().size()).isEqualTo(EXISTING_COUNT);
    }

    @DisplayName("Удаление книги в БД")
    @Test
    void deleteById() {
        assertThatCode(()-> bookDaoJdbc.getById(EXISTING_BOOKS_ID)).doesNotThrowAnyException();

        bookDaoJdbc.deleteById(EXISTING_BOOKS_ID);

        assertThatThrownBy(()-> bookDaoJdbc.getById(EXISTING_BOOKS_ID)).isInstanceOf(EmptyResultDataAccessException.class);
    }
}