package ru.otus.hw.dao;

import ru.otus.hw.domain.Genre;

import java.util.List;

public interface GenreDao {

    int count();

    void insert(Genre genre);

    Genre getById(long id);

    Genre getByGenre(String genreName);

    List<Genre> getAll();

}
