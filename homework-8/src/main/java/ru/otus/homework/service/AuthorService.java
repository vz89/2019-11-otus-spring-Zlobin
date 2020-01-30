package ru.otus.homework.service;

import ru.otus.homework.domain.Author;
import ru.otus.homework.dto.AuthorBookCountAggregateResult;

import java.util.List;

public interface AuthorService {
    Author getAuthor(String authorName);

    Author findById(long id);

    List<AuthorBookCountAggregateResult> findAllAuthorsWithBooksCount();
}
