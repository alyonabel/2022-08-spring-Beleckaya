package ru.otus.hw.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dao.GenreDao;
import ru.otus.hw.domain.Genre;
import ru.otus.hw.service.GenreService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    @Override
    public long addGenreIfDoesntExist(String genreName) {
        List<Genre> authorList = genreDao.getAll();
        if(authorList.stream().filter(s ->s.getGenreName().equals(genreName)).findAny().isEmpty()){
            long i = genreDao.count();
            genreDao.insert(new Genre(i+1,genreName));
            return genreDao.count();
        }
        else return genreDao.getByGenre(genreName).getId();
    }
    }

