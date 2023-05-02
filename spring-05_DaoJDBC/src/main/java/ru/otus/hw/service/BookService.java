package ru.otus.hw.service;

public interface BookService {

    int countBooks();
    long create(String name, String author, String genre);
    String showBook(long id);
    void updateBook(long id, String name,String author, String genre);
    void delete(long id);
    String showAll();
}
