package ru.otus.homework.service;

import ru.otus.homework.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment save(Comment comment);

    List<Comment> findByBookId(long id);

    List<Comment> findByBookName(String name);

    void updateTextById(long id, String text);

    void deleteById(long id);

    void addNewComment();
}
