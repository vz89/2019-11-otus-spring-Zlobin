package ru.otus.homework.service;

import ru.otus.homework.domain.Author;
import ru.otus.homework.domain.Book;

import java.util.List;

public interface AuthorService {
    Author getAuthor(String authorName);

    List<Book> addBookToAuthorsBookList(Author author, Book book);

    List<Author> findAllWithBooksCount();

    List<Book> findAllBooksByAuthorId(long id);

    Author findById(long id);
}
