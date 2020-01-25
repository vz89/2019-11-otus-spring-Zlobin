package ru.otus.homework.repo;

import ru.otus.homework.utils.AuthorBookCountAggregateResult;

import java.util.List;

public interface BookRepoCustom {
    void deleteCommentById(long id);
}
