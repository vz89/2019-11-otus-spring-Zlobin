package ru.otus.homework.service;

import ru.otus.homework.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    int getCount();
    void insert(Book book);
    Book getById(long id);
    void deleteById(long id);


    Book getNewBook();
}
