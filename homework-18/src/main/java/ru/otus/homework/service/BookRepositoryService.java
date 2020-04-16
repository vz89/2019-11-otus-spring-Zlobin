package ru.otus.homework.service;

import ru.otus.homework.domain.Book;

import java.util.List;

public interface BookRepositoryService {
    List<Book> findAll();
    Book findById(Long id);

    void deleteBookById(Long id);

    void save(Book book);
}
