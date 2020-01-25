package ru.otus.homework.service;

import ru.otus.homework.utils.AuthorBookCountAggregateResult;
import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;

import java.util.List;

public interface BookService {
    void addBook();

    List<Book> findAll();

    Book findById(long id);

    void deleteById(long id);

    long getCount();

    void updateNameById(long id, String name);

    List<Book> findByName(String name);

    void addComment();

    List<Comment> findCommentsByBookId(long id);

    List<AuthorBookCountAggregateResult> findAllAuthorsWithBooksCount();
}
