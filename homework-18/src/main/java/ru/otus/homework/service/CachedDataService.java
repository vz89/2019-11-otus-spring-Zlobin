package ru.otus.homework.service;

import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;

import java.util.List;

public interface CachedDataService {
    List<Book> getCachedBooks();

    Book getCachedBook();

    List<Comment> getCachedComments();
}
