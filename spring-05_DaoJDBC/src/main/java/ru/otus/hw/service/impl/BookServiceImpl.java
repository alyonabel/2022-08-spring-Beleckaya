package ru.otus.hw.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.hw.dao.BookDao;
import ru.otus.hw.service.AuthorService;
import ru.otus.hw.service.BookService;
import ru.otus.hw.service.GenreService;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;
    private final AuthorService authorService;
    private final GenreService genreService;


    @Override
    public int countBooks() {
        return bookDao.count();
    }

    @Override
    public long create(String name, String author, String genre) {
        long authorId = authorService.addAuthorIfDoesntExist(author);
        long genreId = genreService.addGenreIfDoesntExist(genre);
        long id = countBooks()+1;
        bookDao.insert(id,name,authorId,genreId);
        return id;
    }

    @Override
    public String showBook(long id) {
    return bookDao.getById(id).toString();
    }

    @Override
    public String showAll() {
        return bookDao.getAll().toString();
    }

    @Override
    public void updateBook(long id, String name, String author, String genre) {
        long authorId = authorService.addAuthorIfDoesntExist(author);
        long genreId = genreService.addGenreIfDoesntExist(genre);
        bookDao.update(id,name,authorId,genreId);
    }

    @Override
    @Transactional
    public void delete(long id) {
        bookDao.deleteById(id);
           }

 }
