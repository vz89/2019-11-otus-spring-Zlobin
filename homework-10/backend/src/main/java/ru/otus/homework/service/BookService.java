package ru.otus.homework.service;

import ru.otus.homework.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    void addBook(Book book);

    void delete(Book book);

    Book findById(long id);

    boolean update(long id, Book book);

    boolean deleteById(Long id);
}
