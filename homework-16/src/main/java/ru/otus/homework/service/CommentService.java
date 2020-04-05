package ru.otus.homework.service;

import ru.otus.homework.domain.Book;
import ru.otus.homework.domain.Comment;

import java.util.List;

public interface CommentService {


    List<Comment> findAllComments(Book book);

    void addOrSaveComment(Comment comment);

    void deleteById(Long id);
}
