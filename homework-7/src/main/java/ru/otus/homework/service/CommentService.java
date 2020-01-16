package ru.otus.homework.service;

import ru.otus.homework.domain.Comment;

import java.util.List;

public interface CommentService {
    Comment save(Comment comment);

    List<Comment> findByBookId(long id);

    void updateTextById(long id, String text);

    void deleteById(long id);

    void addNewComment();

    List<Comment> findAllCommentsByAuthorId(long id);

}
