package ru.otus.homework.dao;

import ru.otus.homework.domain.Comment;

import java.util.List;

public interface CommentDao {
    Comment save(Comment comment);

    List<Comment> findByBookId(long id);

    List<Comment> findByBookName(String name);

    void updateTextById(long id, String text);

    void deleteById(long id);

}