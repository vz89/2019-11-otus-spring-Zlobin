package ru.otus.homework.dao;

import ru.otus.homework.domain.Book;

import java.util.List;

public interface BookDao {
    int getCount();
    long insert(Book book);
    Book getById(long id);
    List<Book> getAll();
    void deleteById(long id);

}
