package ru.otus.homework.service;

import org.springframework.stereotype.Service;
import ru.otus.homework.repo.BookRepo;
import ru.otus.homework.repo.CommentRepo;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;
    private final BookRepo bookRepo;

    public CommentServiceImpl(CommentRepo commentRepo, BookRepo bookRepo) {
        this.commentRepo = commentRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void deleteById(long id) {
        commentRepo.deleteById(id);
        bookRepo.deleteCommentById(id);
    }
}
