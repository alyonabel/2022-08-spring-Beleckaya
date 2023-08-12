package ru.otus.hw.dao;

import ru.otus.hw.domain.Author;

import java.util.List;

public interface AuthorDao {

    int count();

    void insert(Author author);

    Author getById(long id);

    Author getByAuthor(String authorName);

    List<Author> getAll();

}
