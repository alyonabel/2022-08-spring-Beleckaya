package ru.otus.hw.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.hw.dao.AuthorDao;
import ru.otus.hw.domain.Author;
import ru.otus.hw.service.AuthorService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao;

    @Override
    public long addAuthorIfDoesntExist(String authorName) {
      List<Author> authorList = authorDao.getAll();
      if(authorList.stream().filter(s ->s.getAuthorName().equals(authorName)).findAny().isEmpty()){
        long i = authorDao.count();
        authorDao.insert(new Author(i+1,authorName));
        return authorDao.count();
        }
      else return authorDao.getByAuthor(authorName).getId();
    }
}
