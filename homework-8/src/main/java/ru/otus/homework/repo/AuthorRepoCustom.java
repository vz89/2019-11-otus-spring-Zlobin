package ru.otus.homework.repo;

import ru.otus.homework.dto.AuthorBookCountAggregateResult;

import java.util.List;

public interface AuthorRepoCustom {
    List<AuthorBookCountAggregateResult> findAllAuthorsWithBooksCount();
}
