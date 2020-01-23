package ru.otus.homework.repo;

import ru.otus.homework.domain.AuthorBookCount;

import java.util.List;

public interface BookRepoCustom {
    List<AuthorBookCount> findAllAuthorsWithBooksCount();
}
