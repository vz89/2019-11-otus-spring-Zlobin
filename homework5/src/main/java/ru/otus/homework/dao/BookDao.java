package ru.otus.homework.dao;

import ru.otus.homework.domain.Book;

import java.util.List;

public interface BookDao {
    int count();
    void insert(Book book);
    Book getById(long id);
    List<Book> getAll();


}
