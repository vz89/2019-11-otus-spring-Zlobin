package ru.otus.homework.service;

import ru.otus.homework.domain.Comment;

public interface CommentDBService {
    void delete(Comment comment);

    void save(Comment comment);
}
