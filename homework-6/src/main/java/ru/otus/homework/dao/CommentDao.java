package ru.otus.homework.dao;

import ru.otus.homework.domain.Comment;

import java.util.List;

public interface CommentDao {
    Comment save(Comment comment);

    List<Comment> findByBookId(long id);

    void updateTextById(long id, String text);

    void deleteById(long id);

    List<Comment> findAllCommentsByAuthorId(long id);

    void deleteByBookId(long id);
}