package ru.otus.homework.service;

import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;

import java.util.List;


public interface DBService extends BookDBService, CommentDBService{
    void save(Book book);

    List<Book> findAll();

    Book findById(long id);

    void delete(Comment comment);

    void deleteById(long id);

    long count();

    List<Book> findAllByTitle(String name);

    void save(Comment comment);

    List<Book> findAllByAuthorId(long id);
}
