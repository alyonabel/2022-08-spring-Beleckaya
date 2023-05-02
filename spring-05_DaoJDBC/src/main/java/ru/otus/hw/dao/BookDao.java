package ru.otus.hw.dao;

import ru.otus.hw.domain.Book;

import java.util.List;

public interface BookDao {

        int count();

        void insert(long id,String name,long authorId,long genreId);

        void update(long id,String name,long authorId,long genreId);

        Book getById(long id);

        List<Book> getAll();

        void deleteById(long id);

}
