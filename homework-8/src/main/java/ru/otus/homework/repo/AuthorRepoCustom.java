package ru.otus.homework.repo;

import ru.otus.homework.utils.AuthorBookCountAggregateResult;

import java.util.List;

public interface AuthorRepoCustom {
    void deleteBookById(long id);
    List<AuthorBookCountAggregateResult> findAllAuthorsWithBooksCount();
}
