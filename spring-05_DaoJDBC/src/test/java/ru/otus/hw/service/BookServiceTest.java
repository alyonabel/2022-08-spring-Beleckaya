package ru.otus.hw.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.otus.hw.dao.jdbc.BookDaoJdbc;
import ru.otus.hw.service.impl.AuthorServiceImpl;
import ru.otus.hw.service.impl.BookServiceImpl;
import ru.otus.hw.service.impl.GenreServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;

@DisplayName("Сервис для работы с книгами")
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookDaoJdbc bookDao;

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private AuthorServiceImpl authorService;

    @Mock
    private GenreServiceImpl genreService;

    private static final String EXISTING_BOOK = "Madame Bovary";

    @DisplayName("Количество книг")
    @Test
    void shouldCountReturn1() {
        Mockito.doReturn(1).when(bookDao).count();
        assertThat(bookService.countBooks()).isEqualTo(1);
    }

    @DisplayName("Cоздание книги")
    @Test
    void createNewBook() {
        int currentCount = 3;
        String name = "Saint Joan";
        String author = "Bernard Shaw";
        String genre = "drama";
        Mockito.doReturn(currentCount).when(bookDao).count();
        long authorId = 2;
        long genreId = 4;
        Mockito.doReturn(authorId).when(authorService).addAuthorIfDoesntExist(author);
        Mockito.doReturn(genreId).when(genreService).addGenreIfDoesntExist(genre);
        int id = currentCount + 1;
        assertThat(bookService.create(name, author, genre)).isEqualTo(id);
        Mockito.verify(bookDao, times(1)).insert(id, name, authorId, genreId);
    }
    @DisplayName("Обновление книги")
    @Test
    void updateBook() {
        String genre = "drama";
        String author = "Bernard Shaw";
        bookService.updateBook(1,EXISTING_BOOK ,author, genre);

        Mockito.verify(authorService, times(1)).addAuthorIfDoesntExist(author);
        Mockito.verify(genreService, times(1)).addGenreIfDoesntExist(genre);
        Mockito.verify(bookDao, times(1)).update(eq(1L),eq(EXISTING_BOOK),anyLong(), anyLong());
    }

    @DisplayName("Удаление книги")
    @Test
    void deleteBook() {
        int id = 1;
        bookService.delete(id);
        Mockito.verify(bookDao, times(id)).deleteById(id);
    }

    @DisplayName("Выбор всех книг")
    @Test
    void showAllBooksWithoutException() {
        assertThatCode(()-> bookService.showAll()).doesNotThrowAnyException();
    }
}